public void someMethod(String myString) {
    if (myString == null)
        throw new NullPointerException();
    if ("hello".equals(myString))
        // do something
}