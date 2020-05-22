public class DatePickin extends javafx.embed.swing.JFXPanel {

    private DatePicker date_Picker;
    private LocalDate dateValue;
    //...

    public void getDate() {
        date_Picker = new DatePicker();
        date_Picker.setShowWeekNumbers(false);
        date_Picker.setOnAction((e) -> {

            try {
                dateValue = date_Picker.getValue();
            } catch (UnsupportedOperationException uoe) {
                uoe.printStackTrace();
            }
        });
    }

    public LocalDate getDateValue() {
        return dateValue;
    }