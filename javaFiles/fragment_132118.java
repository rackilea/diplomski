import java.lang.reflect.*;

// This class won't have access to Foo's member 'bar'
public class Test {

    void doStuff() {
        // create a new instance of Foo
        Foo foo = new Foo();
        try {
            // use reflection to get the variable named 'bar'
            Field barField = foo.getClass().getDeclaredField("bar");

            // attempt to access the value of 'bar' which will throw an exception
            System.out.println(barField.get(foo));

       } catch (NoSuchFieldException e) {
           throw new RuntimeException(e);
       } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
       }
    }

    public static void main(String[] args) {
        new Test().doStuff();
    }

}