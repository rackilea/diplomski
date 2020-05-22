import java.lang.reflect.*;
public class Foo {
    private List<String> fooField;

    public static void main(String[] args) throws Exception{
        for (Field f : Foo.class.getDeclaredFields()) {
            if (f.getName().equals("fooField")) {
                System.out.println("Generic Types " + f.getGenericType());
                break;
            }
        }
    }
}