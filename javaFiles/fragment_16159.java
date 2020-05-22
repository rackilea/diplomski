package be.pbeckers.javafxguiupdater;

import java.util.concurrent.ConcurrentLinkedQueue;

import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


/**
 * Class for enabling fast updates of GUI components from outside the JavaFX thread.
 *  Updating GUI components (such as labels) should be done from the JavaFX thread by using Platform.runLater for example.
 *  This makes it hard to update the GUI with a fast changing variable as it is very easy to fill up the JavaFX event queue faster than it can be emptied (i.e. faster than it can be drawn).
 *  This class binds ObservableValues to (GUI) Properties and ensures that quick consecutive updates are ignored, only updating to the latest value.
 */
public abstract class GUIUpdater {
    private static  ConcurrentLinkedQueue<PropertyUpdater<?>>   dirtyPropertyUpdaters   =   new ConcurrentLinkedQueue<>();
    private static  Updater                                     updater                 =   new Updater();
    private static  boolean                                     isUpdating              =   false;

    /**
     * Binds an ObservableValue to a Property.
     *  Updates to the ObservableValue can be made from outside the JavaFX thread and the latest update will be reflected in the Property.
     * @param property      (GUI) Property to be updated/
     * @param observable    ObservableValue to update the GUI property to.
     */
    public static <T> void bind(Property<T> property, ObservableValue<T> observable) {
        PropertyUpdater<T>  propertyUpdater = new PropertyUpdater<>(property, observable);
        observable.addListener(propertyUpdater);
    }

    /**
     * Unbinds the given ObservableValue from the given Property.
     *  Updates to the ObservableValue will no longer be reflected in the Property.
     * @param property      (GUI) Property to unbind the ObservableValue from.
     * @param observable    ObservableValue to unbind from the given Property.
     */
    public static <T> void unbind(Property<T> property, ObservableValue<T> observable) {
        PropertyUpdater<T>  tmpPropertyUpdater = new PropertyUpdater<>(property, observable);
        observable.removeListener(tmpPropertyUpdater);
    }

    /**
     * Schedules an update to the GUI by using a call to Platform.runLater().
     *  The updated property is added to the dirtyProperties list, marking it for the next update round.
     *  Will only submit the event to the event queue if the event isn't in the event queue yet.
     * @param updater
     */
    private static synchronized void scheduleUpdate(PropertyUpdater<?> updater) {
        GUIUpdater.dirtyPropertyUpdaters.add(updater);

        if (!GUIUpdater.isUpdating) {
            GUIUpdater.isUpdating = true;
            Platform.runLater(GUIUpdater.updater);
        }
    }

    /**
     * Class used for binding a single ObservableValue to a Property and updating it.
     *
     * @param <T>
     */
    private static class PropertyUpdater<T> implements ChangeListener<T> {
        private boolean             isDirty     =   false;
        private Property<T>         property    =   null;
        private ObservableValue<T>  observable  =   null;

        public PropertyUpdater(Property<T> property, ObservableValue<T> observable) {
            this.property = property;
            this.observable = observable;
        }

        @Override
        /**
         * Called whenever the ObservableValue has changed. Marks this Updater as dirty.
         */
        public synchronized void changed(ObservableValue<? extends T> observable, T oldValue, T newValue) {
            if (!this.isDirty) {
                this.isDirty = true;
                GUIUpdater.scheduleUpdate(this);
            }
        }

        /**
         * Updates the Property to the ObservableValue and marks it as clean again.
         *  Should only be called from the JavaFX thread.
         */
        public synchronized void update() {
            T value = this.observable.getValue();
            this.property.setValue(value);
            this.isDirty = false;
        }

        @Override
        /**
         * Two PropertyUpdaters are equals if their Property and ObservableValue map to the same object (address).
         */
        public boolean equals(Object otherObj) {
            PropertyUpdater<?>  otherUpdater = (PropertyUpdater<?>) otherObj;
            if (otherObj == null) {
                return false;
            } else {
                // Only compare addresses (comparing with equals also compares contents):
                return (this.property == otherUpdater.property) && (this.observable == otherUpdater.observable);
            }
        }
    }

    /**
     * Simple class containing the Runnable for the call to Platform.runLater.
     *  Hence, the run() method should only be called from the JavaFX thread.
     *
     */
    private static class Updater implements Runnable {

        @Override
        public void run() {
            synchronized (GUIUpdater.class) {

                // Loop through the individual PropertyUpdaters, updating them one by one:
                while(!GUIUpdater.dirtyPropertyUpdaters.isEmpty()) {
                    PropertyUpdater<?>  curUpdater = GUIUpdater.dirtyPropertyUpdaters.poll();
                    curUpdater.update();
                }

                // Mark as updated:
                GUIUpdater.isUpdating = false;              
            }
        }

    }
}