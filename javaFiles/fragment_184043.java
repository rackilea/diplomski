public class Book {

    private boolean checkedOut = false;

    public void checkout() {
        checkedOut = true;
    }

    public void checkin() {
        checkedOut = false;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }
}