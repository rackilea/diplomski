public class Hello {   

    String title;
    int value;

    public void append() {
        title += "World";
    }

    public void setValue(int value) {
        this.value = value;
        title = "Hello";
        append();
    }
}