public class MyClass {
    private String message;
    public MyClass(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return message;
    }
}