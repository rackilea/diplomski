for (Application app : model.getCheckedApplications()) {
    List<JTextField> data = myMap.get(app);
    for(JTextField field : data) {
        field.getText();
    }
}