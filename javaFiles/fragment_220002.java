public class Test {
    class Value {
        int i = 15;
    }

    public void second( Value v ) {
        System.out.println( " 2.1.1: entered: v.i = " + v.i ); // 25
        System.out.println( " 2.1.2: v.hashCode() = " + v.hashCode() + "; v = " + v.toString() );

        v = new Value();
        v.i = 9;
        System.out.println( " 2.2.1:   new V: v.i = " + v.i ); // 9
        System.out.println( " 2.2.2: v.hashCode() = " + v.hashCode() + "; v = " + v.toString() );
    } // second(v)

    public Value third( Value v ) {
        System.out.println( " 3.1.1:  entered: v.i = " + v.i ); // 25
        System.out.println( " 3.1.2:  v.hashCode() = " + v.hashCode() + "; v = " + v.toString() );

        v = new Value();
        v.i = 9;
        System.out.println( " 3.2.1:  created: v.i = " + v.i ); // 9
        System.out.println( " 3.2.2:  v.hashCode() = " + v.hashCode() + "; v = " + v.toString() );

        return v;
    } // third(v)

    public Value fourth( final Value v ) {
        System.out.println( " 4.1.1:entered: v.i = " + v.i ); // 9
        System.out.println( " 4.1.2:v.hashCode() = " + v.hashCode() + "; v = " + v.toString() );

        /**********************************
        // The final local v can't be assigned. It must be blank and not using a compound assignment.
        // meaning, you are not allowed to change its memory location,
        // but can alter its content, if permitted
        // v = new Value();
        //**********************************/

        v.i = 45;
        System.out.println( " 4.2.1:changed: v.i = " + v.i ); // 45
        System.out.println( " 4.2.2:v.hashCode() = " + v.hashCode() + "; v = " + v.toString() );

        return v;
    } // fourth(v)

    public void first() {
        System.out.println( "1.1.1: entered: ..." );

        Value v = new Value();
        System.out.println( "1.2.1: created; v.i = " + v.i ); // 15
        v.i = 25;
        System.out.println( "1.2.2: changed: v.i = " + v.i ); // 25
        System.out.println();

        System.out.println( "1.3.1: before calling second(v) ..." );
        System.out.println( " v.i = " + v.i + ", v.hashCode() = " + v.hashCode() + "; v = " + v.toString() );
        second( v );
        System.out.println( "1.3.2: returning from second(v) ..." );
        System.out.println( " v.i = " + v.i + ", v.hashCode() = " + v.hashCode() + "; v = " + v.toString() );
        System.out.println();

        System.out.println( "1.4.1:  before calling third(v) ..." );
        System.out.println( " v.i = " + v.i + ", v.hashCode() = " + v.hashCode() + "; v = " + v.toString() );
        v = third( v );
        System.out.println( "1.4.2:  returning from third(v) ..." );
        System.out.println( " v.i = " + v.i + ", v.hashCode() = " + v.hashCode() + "; v = " + v.toString() );
        System.out.println();

        System.out.println( "1.5.1: before calling fourth(v) ..." );
        System.out.println( " v.i = " + v.i + ", v.hashCode() = " + v.hashCode() + "; v = " + v.toString() );
        v = fourth( v );
        System.out.println( "1.5.2: returning from fourth(v) ..." );
        System.out.println( " v.i = " + v.i + ", v.hashCode() = " + v.hashCode() + "; v = " + v.toString() );
    } // first()

    public static void main( String ... a ) {
        Test _this = new Test();
        _this.first();
    } // psvm(...)
} // class Test