@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) @Inherited
public @interface Baz { String value(); }

public interface Foo{
    @Baz("baz") void doStuff();
}

public interface Bar{
    @Baz("phleem") void doStuff();
}

public class Flipp{
    @Baz("flopp") public void doStuff(){}
}

public class MyClass extends Flipp implements Foo, Bar{}