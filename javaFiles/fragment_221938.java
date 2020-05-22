import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.collections.transformation.TransformationList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WrappedObjectListExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        ObservableList<String> stringList = FXCollections.observableArrayList("One", "Two", "Three");
        ObservableList<Warning> warningList = new CachingMappedList<Warning, String>(stringList, Warning::new);

        ListView<String> stringListView = new ListView<>(stringList);
        ListView<Warning> warningListView = new ListView<>(warningList);

        warningListView.setCellFactory(CheckBoxListCell.forListView(Warning::checkedProperty));

        TextField textField = new TextField();
        textField.setOnAction(e -> {
            if (! textField.getText().isEmpty()) {
                stringList.add(textField.getText());
                textField.setText("");
            }
        });

        Button remove = new Button("Remove");
        remove.setOnAction(e -> stringList.remove(stringListView.getSelectionModel().getSelectedIndex()));
        remove.disableProperty().bind(stringListView.getSelectionModel().selectedItemProperty().isNull());

        HBox lists = new HBox(10, stringListView, warningListView);
        VBox root = new VBox(10, lists, textField, remove);
        root.setPadding(new Insets(20));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static class Warning {
        private final ReadOnlyStringWrapper name = new ReadOnlyStringWrapper();
        private final BooleanProperty checked = new SimpleBooleanProperty();

        public Warning(String name) {
            this.name.set(name);
        }

        public final ReadOnlyStringProperty nameProperty() {
            return this.name.getReadOnlyProperty();
        }

        public final String getName() {
            return this.nameProperty().get();
        }

        public final BooleanProperty checkedProperty() {
            return this.checked;
        }

        public final boolean isChecked() {
            return this.checkedProperty().get();
        }

        public final void setChecked(final boolean checked) {
            this.checkedProperty().set(checked);
        }

        @Override
        public String toString() {
            return getName();
        }

    }

    public static class CachingMappedList<S,T> extends TransformationList<S, T> {

        private final Function<T, S> mapper ;

        private final IdentityHashMap<T, S> cache ;

        public CachingMappedList(ObservableList<T> source, Function<T,S> mapper) {
            super(source);
            this.mapper = mapper ;
            this.cache = new IdentityHashMap<>();
        }

        @Override
        protected void sourceChanged(Change<? extends T> c) {

            fireChange(new Change<S>(this) {

                @Override
                public boolean wasAdded() {
                    return c.wasAdded();
                }

                @Override
                public boolean wasRemoved() {
                    return c.wasRemoved();
                }

                @Override
                public boolean wasReplaced() {
                    return c.wasReplaced();
                }

                @Override
                public boolean wasUpdated() {
                    return c.wasUpdated();
                }

                @Override
                public boolean wasPermutated() {
                    return c.wasPermutated();
                }


                @Override
                public boolean next() {
                    return c.next();
                }

                @Override
                public void reset() {
                    c.reset();
                }

                @Override
                public int getFrom() {
                    return c.getFrom();
                }

                @Override
                public int getTo() {
                    return c.getTo();
                }

                @Override
                public List<S> getRemoved() {
                    List<S> removed = new ArrayList<>();
                    c.getRemoved().forEach(t -> removed.add(cache.get(t)));
                    return removed;
                }

                @Override
                public int getPermutation(int i) {
                    return c.getPermutation(i);
                }

                @Override
                protected int[] getPermutation() {
                    throw new AssertionError("Unreachable code");
                }

            });

            // clean up cache:

            c.reset();
            while (c.next()) {
                if (c.wasRemoved()) {
                    c.getRemoved().forEach(cache::remove);
                }
            }            
        }

        @Override
        public int getSourceIndex(int index) {
            return index ;
        }

        @Override
        public S get(int index) {
            return cache.computeIfAbsent(getSource().get(index), mapper);
        }

        @Override
        public int size() {
            return getSource().size();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}