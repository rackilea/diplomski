public class Contact {
    public String first;
    public String last;
    public String number;

    public Contact(String first, String last, String number) {
        this.first = first;
        this.last = last;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Contact [first=" + first + ", last=" + last + ", number="
                + number + "]";
    }

}