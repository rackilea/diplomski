public class Contact {
    private String first; // first name
    private String last; // last name
    private String phone; // phone number

    public Contact(String f, String l, String p) {
        first = f;
        last = l;
        phone = p;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getPhone() {
        return phone;
    }

    public Contact makeCopy() {
        return new Contact(first, last, phone);
    }
    @Override
    public String toString() {
        return first + " " + last + "; phone number: " + phone;
    }
}