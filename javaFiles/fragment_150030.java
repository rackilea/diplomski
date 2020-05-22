public class Film {
    private String title;
    private int length;
    // more attributes if you have ...

    public Film(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return title + " : " + length;
    }
}