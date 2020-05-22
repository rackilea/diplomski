import java.util.Date;

public class CommonFactory {

    public static Object create(Class<?> clazz) {
        if(Foo.class == clazz) {
            return new Foo(new Date());
        } else if(Bar.class == clazz) {
            return new Bar(new Date());
        }
        return null;
    }

}