public void myMethod( String[] foo ) {
    // do something
    System.out.println( foo[0] );
}

// compilation error!!!
myMethod( "a", "b", "c" );

// compilation error too!!!
myMethod();

// now, just this works
myMethod( new String[]{ "a", "b", "c" } );