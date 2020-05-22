observableList.addListener((ListChangeListener) change -> {
    while (change.next()) {
        if (change.wasUpdated()) {
            SomeObservableClass changedItem = observableList.get(change.getFrom());
            System.out.println("ListChangeListener item: " + changedItem);
        }
    }
});