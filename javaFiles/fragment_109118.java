public class Person {

    // will use the default log level (INFO)
    @LogMethodCall
    public void foo( int a ) {
        System.out.println( "foo! " + a );
    }

    @LogMethodCall( logLevel = Logger.DEBUG )
    public void bar( int b ) {
        System.out.println( "bar! " + b );
    }

}