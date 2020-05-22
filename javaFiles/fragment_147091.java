import java.lang.reflect.Field;

class Something {
    private String name = "Hello";

    public void printName() {
        System.out.println(name);
    }
}

public class Example {
    public static void main(String[] args) throws Exception {
        Something s = new Something();
        s.printName();

        Field field = s.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(s, "Goodbye");

        s.printName();
    }
}