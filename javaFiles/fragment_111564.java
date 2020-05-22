public enum DescribedColor {
    CV_LOAD_IMAGE_COLOR("CV load image color", "red"),
    ...

    private String description;
    private String color;

    private DescribedColor(String description, String color) {
        this.description = description;
        this.color = color;
    }
}