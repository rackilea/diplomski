private String someMethod(String myParam) {
    String result = "";
    try {
        MyInterface myVar = (MyInterface) domeSomething(myParam);
        if (myVar != null) {
            result = myVar.methodThatReturnsString();
        }
    } catch (Exception e) {
        //handle the exception
        //basic handling shown
        System.out.println("Warning. There was a problem executing someMethod:");
        e.printStacktrace();
    }
    return result;
}