import javafx.collections.ListChangeListener.Change ;

// ....

TableView<Person> table = ... ;

table.getItems().addListener((Change<? extends Person> c) -> {
    while(c.next()) {
        if (c.wasRemoved()) {
            int numRemoved = c.getRemoved().size();
            int index = c.getFrom();
            System.out.println(numRemoved + " items removed from table at index "+index);
        }
    }
});