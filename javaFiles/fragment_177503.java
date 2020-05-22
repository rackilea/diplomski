public class A {
    final String text = getText();

    private String getText() {
        System.out.println("text= " + text);
        return "is set";
    }

    public static void main(String... args) {
        new A().getText();
    }
}