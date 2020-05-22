@FXML
public void dateTimePicker(){
    CalendarPicker dateTime = new CalendarPicker();
    dateTime.withCalendar(Calendar.getInstance());
    dateTime.withShowTime(Boolean.TRUE);
    dateTime.withLocale(Locale.ENGLISH);
    dateTime.calendarProperty().addListener(new ChangeListener<Calendar>() {

        public void changed(ObservableValue<? extends Calendar> ov, Calendar t, Calendar t1) {
            System.out.println("Selected date: "+t1.getTime().toString());
        }
    });
    StackPane root = new StackPane();
    root.getChildren().add(dateTime);

    Scene scene = new Scene(root, 300, 250);

    Stage stage = new Stage();

    stage.setTitle("Date & Time from JFXtras 2.2");
    stage.setScene(scene);
    stage.show();
}