ObservableList<Meal> selected = ...;

// List.copyOf is a Java 10 method (and doesn't accept null elements)
table.getItems().removeAll(List.copyOf(selected));

// Pre Java 10 you can use toArray since ObservableList overloads removeAll
// with a version that takes a varargs parameter
table.getItems().removeAll(selected.toArray(new Meal[0]));

// or use the copy constructor of many collection classes
table.getItems().removeAll(new ArrayList<>(selected));

// In Java 11, toArray can be replaced with
table.getItems().removeAll(selected.toArray(Meal[]::new));