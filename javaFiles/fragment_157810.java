@FXML 
CheckComboBox comboBoxProject;

private void initializeComboBox() {
    final List<String> projects = new ArrayList();
    for (String x : db.getProjectBag()) {
        projects.add(x);
    }

    comboBoxProject.getItems().setAll(projects);
}