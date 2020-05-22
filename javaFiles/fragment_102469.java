// method declared to return the interface, ListModel
private ListModel<String> getListModel() {
    String[] arrayOfStrings = {"one", "two", "three"};

    // make sure to use generic types
    DefaultListModel<String> listModel = new DefaultListModel<>();
    for (String txt : arrayOfStrings) {
        listModel.addElement(txt);
    }
    return listModel; // don't forget to return a result
}