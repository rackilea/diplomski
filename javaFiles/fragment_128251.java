public class Note {

    private String title;
    private String text;
    private String color;

    public Note(String title, String text, String color) {
        this.title = title;
        this.text = text;
        this.color = color;
    }


    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getColor() {
        return color;
    }
}