public class MyForm {

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private DateTime dateTime;

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }
}