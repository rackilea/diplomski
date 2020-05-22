public class Test {
    public static void main( String[] args ) throws Exception {
        recursive();
    }

    public static void recursive() throws Exception {
        try {
            Test.class
                    .getDeclaredMethod( "recursive" )
                    .invoke( null );
        } catch ( InvocationTargetException e ) {
            e.printStackTrace();
        }
    }
}