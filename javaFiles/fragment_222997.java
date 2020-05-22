public class Event {

    private Date date;
    private int color;

    public Event(Date date, int color) {
        this.date = date;
        this.color = color;
    }

    public Date getDate() {
        return date;
    }

    public int getColor() {
        return color;
    }
}