void myMethod( int counter) {
    if(counter == 0)
        return;
    else {
        System.out.println("hello" + counter);
        myMethod(--counter);
        System.out.println(""+counter);
        return;
    }
}