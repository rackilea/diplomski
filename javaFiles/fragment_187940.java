import java.lang.reflect.Field;

public class Test
{
    // Obviously in real code you wouldn't use Exception like this...
    // Although hacking string values with reflection is worse, of course.
    public static void main(String[] args) throws Exception
    {        
        System.out.println("Hello World");
        replaceHelloWorld("Goodbye!");
        System.out.println("Hello World");
        replaceHelloWorld("Hello again!");
        System.out.println("Hello World");
    }

    static void replaceHelloWorld(String text) throws Exception
    {
        // Note: would probably want to do hash as well...
        copyField(text, "Hello World", "value");
        copyField(text, "Hello World", "offset");
        copyField(text, "Hello World", "count");
    }

    static void copyField(String source, String target, String name)
        throws Exception
    {
        Field field = String.class.getDeclaredField(name);
        field.setAccessible(true);
        field.set(target, field.get(source));
    }
}