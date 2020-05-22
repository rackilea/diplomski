public class MyData {
    private String name;
    private Image image;

    public MyData(String name, String imageUrl) {
        this.name = name;
        this.image = new Image(imageUrl);
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }
}