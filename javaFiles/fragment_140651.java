public class Hello {   

    String title;
    int value;

    public Hello() {
        title += "World";
    }

    public Hello(int value) {
        this();
        this.value = value;
        title = "Hello";
    }
}