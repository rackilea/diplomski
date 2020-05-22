tableColumns[1].setCellValueFactory(
    new PropertyValueFactory<DiaryEntry,Project>("project")
);
tableColumns[1].setCellFactory(col -> new TableCell<DiaryEntry, Project>() {
    @Override
    protected void updateItem(Project project, boolean empty) {
        super.updateItem(project, empty);
        if (empty) {
            setText(null);
        } else {
            setText(project.getName());
        }
    }
});