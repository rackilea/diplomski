// I can imagine this been loaded from a ResultSet
ObservableList<Course> options = FXCollections.observableArrayList(
                new Course(0, "JavaFX"),
                new Course(1, "Swing"),
                new Course(2, "Objective C"),
                new Course(3, "Swift")
);
ComboBox<Course> comboBox = new ComboBox<Course>(options);
comboBox.setCellFactory(new Callback<ListView<Course>, ListCell<Course>>() {
    @Override
    public ListCell<Course> call(ListView<Course> courses) {
        return new CourseCell();
    }
});
comboBox.setButtonCell(new CourseCell());