class StringAndObject {
    public void workWithString( String s ) {} // We just care about 
    public void workWithObject( Object o ) {} // the signature. 

    public void run() {

        String s = ""; // s declared as String
        Object o = s;  // o declared as Object

        // works because a String is also an Object
        workWithObject( s );
        // naturally a s is and String
        workWithString( s );


        // works because o is an Object
        workWithObject( o );
        // compiler error.... 
        workWithString( o );

    }

}