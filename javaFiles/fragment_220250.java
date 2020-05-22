enum Light {
    NONE(""), RED("Red"), YELLOW("Yellow"), GREEN("Green");

    private String text;

    private Light(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}