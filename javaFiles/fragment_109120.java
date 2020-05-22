public class AnnotationProcessing {

    public static void main(String[] args) {

        Person p = new Person();
        Utils.log( p, "foo" );
        p.foo( 2 );
        Utils.log( p, "bar" );
        p.bar( 3 );

    }
}