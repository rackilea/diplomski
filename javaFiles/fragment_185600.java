ObservableList<String> obsList = 
    FXCollections.observableArrayList("Amanda", "Bill", "Adam", "Albus", "Cicero");
FilteredList<String> fList = new FilteredList<>(obsList, s -> s.startsWith("A"));

System.out.println(fList);
FXCollections.shuffle(obsList);
System.out.println(fList);