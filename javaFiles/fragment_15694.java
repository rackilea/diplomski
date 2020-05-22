public class Application extends ApplicationBase {
    private String name = "<unnamed>";

    public Application(int id, String name) {
        super(id);
        this.name = name;
    }

    public static void main(String[] args) {
        new Application(1, "Foo");
        new Application(2, "Bar");
    }
}