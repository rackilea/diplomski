public class Item implements Serializable {
    private String title;
    private String text;

    public String getTitle() {
        return title;
    }
    @XmlElement(name = "title")
    @XmlJavaTypeAdapter(value = TitleHandler.class)
    public void setTitle(String title) {
        this.title = title;
    }
    public String getText() {
        return text;
    }
    @XmlElement(name = "text")
    @XmlJavaTypeAdapter(value = TextHandler.class)
    public void setText(String text) {
        this.text = text;
    }
}