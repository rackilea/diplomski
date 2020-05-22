public class MyJodaExtension {

    private final DateTime dateTime;

    public MyJodaExtension(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean myOperation() {
        return false;  // or whatever you need
    }

    public DateTime asDateTime() {
        return dateTime;
    }

}