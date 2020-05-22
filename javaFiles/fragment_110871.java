public class TestExceptions extends Exception {
    public TestExceptions( String s ) {
      super(s);
    }

    public static void main(String[] args) throws TestExceptions{
        try {
            throw new TestExceptions("If you see me, exceptions work!");
        }
        catch( Exception a ) {
            System.out.println("Working Status: " + a.getMessage() );
        }
    }
}