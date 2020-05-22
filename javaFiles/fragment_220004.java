public class Test {
    Value instanceVariableV = null; // v

    // rest of other variables and methods here
        // ...

    public void fifth() {
        System.out.println( " 5.1.1:entered: instanceVariableV = " + instanceVariableV ); // null
        // null, hence no hashCode(), and no toString() will work

        // let us create an instance of Value
        instanceVariableV = new Value();
        System.out.println( " 5.2.1:created: instanceVariableV = " + instanceVariableV ); // Test$Value@9304b1
        System.out.println( " 5.2.2: instanceVariableV.i = " + instanceVariableV.i ); // 15
        System.out.println( " 5.2.3: hashCode = " + instanceVariableV.hashCode() ); // 9634993

        instanceVariableV.i = 20;
        System.out.println( " 5.3.1:changed: instanceVariableV.i = " + instanceVariableV.i ); // 20
        System.out.println( " 5.3.2: hashCode = " + instanceVariableV.hashCode() ); // 9634993 // not changed 
    } // fifth()

    public void first() {
        // continuation of code

        System.out.println( "1.6.1: before calling fifth() ..." );
        System.out.println( " instanceVariableV = " + instanceVariableV  );
        fifth();
        System.out.println( "1.6.2: returning from fifth() ..." );
        System.out.println( " instanceVariableV = " + instanceVariableV  );
        if ( instanceVariableV != null ) {
            // must be different from the one when created new
            System.out.println( " .i = " + instanceVariableV.i );
            // this won't differ
            System.out.println( " .hashCode() = " + instanceVariableV.hashCode() );
        }
    } // first()

    public static void main( String ... a ) {
        // ...
        System.out.println( "\r\nmain(...): vInstanceVariable = " + _this.instanceVariableV );
        if ( _this.instanceVariableV != null ) {
            // must be different from the one when created new
            System.out.println( " .i = " + _this.instanceVariableV.i );
            // this won't differ
            System.out.println( " .hashCode() = " + _this.instanceVariableV.hashCode() );
        }
    } // psvm(...)