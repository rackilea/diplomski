import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.event.SwingPropertyChangeSupport;

publicclass FileEx {
   public static final String SELECTION = "selection";
   private SwingPropertyChangeSupport propertyChangeSupport = new SwingPropertyChangeSupport(
         this);
   private String selection;

   public void someMethodThatChangesSelection() {

   }



   public String getSelection() {
      return selection;
   }

   public void setSelection(String selection) {
      String oldValue = this.selection;
      String newValue = selection;
      this.selection = selection;
      // notify the listeners of change
      propertyChangeSupport.firePropertyChange(SELECTION, oldValue, newValue);
   }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      propertyChangeSupport.addPropertyChangeListener(listener);
   }

   public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
      propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      propertyChangeSupport.removePropertyChangeListener(listener);
   }

   public void rem(String propertyName, PropertyChangeListener listener) {
      propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
   }
}