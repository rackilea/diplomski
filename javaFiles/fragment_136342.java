public void myMethod( String... foo ) {
    // do something
    // foo is an array (String[]) internally
    System.out.println( foo[0] );
}

myMethod( "a", "b", "c" );

// OR
myMethod( new String[]{ "a", "b", "c" } );

// OR without passing any args
myMethod();