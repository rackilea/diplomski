class BadThreadParam implements Runnable {
    static int c;

    public BadThreadParam( int a, int b ) {
        c = a + b;
    }

    public void run() {
        System.out.println( c );
    }
}

class ImmutableThreadParam implements Runnable {
    private final int c;

    public ImmutableThreadParam( int a, int b ) {
        c = a + b;
    }

    public void run() {
        System.out.println( c );
    }
}

public class BadThreadParamTest  {
    public static void main( String[] args ) {
        BadThreadParam shouldBe3 = new BadThreadParam( 1, 2 );
        BadThreadParam shouldBe5 = new BadThreadParam( 3, 2 );
        shouldBe3.run();  // Expect 3 but is 5.  WTF?
        shouldBe5.run();  // Expect 5.

        ImmutableThreadParam expect3 = new ImmutableThreadParam( 1, 2 );
        ImmutableThreadParam expect5 = new ImmutableThreadParam( 3, 2 );
        expect3.run();  // Expect 3.
        expect5.run();  // Expect 5.
    }
}