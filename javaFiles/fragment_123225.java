ObservableList<Integer> ol = FXCollections.observableArrayList();
for (int i = 0; i < 10; i++) {
    ol.add(i);
}

ol.addListener((ListChangeListener.Change<? extends Integer> event) -> {
    System.out.println("new change----------------------------------------------");
    while(event.next()) {
        System.out.println("Added:" +  event.wasAdded());
        System.out.println("Permutated:" +  event.wasPermutated());
        System.out.println("Removed:" +  event.wasRemoved());
        System.out.println("Replaced:" +  event.wasReplaced());
        System.out.println("Updated:" +  event.wasUpdated());
    }
});
ol.retainAll(1, 3, 5, 7, 9);