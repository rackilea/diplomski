public static void myMethod(String fooBar, Integer baz) {

    switch(baz){} // baz gets unboxed, NPE if it was null

    if(baz != null) {
        // Do something
    }
    else {
        // Do something else
    }
}