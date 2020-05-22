public class FooBat {}
public class FooBar {}

public class Foo {
    public static Class get_Bar() { return FooBar.class; }
    public static Class get_Bat() { return FooBat.class; }
}

public class Introspect {
    public static void main(String[] args) {
        if( Foo.get_Bar() == FooBar.class &&
            Foo.get_Bat() == FooBat.class )
            System.out.println( "All is well.\n" );
    }
}