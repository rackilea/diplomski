public void test(String param1) {
    test(param1, null);
}


public void test(String param1, String param2) {
    //this invocation runs async only when real AspectJ is used
    test(param1, param2, null);
}

@Async
public void test(String param1, String param2, String param3) {
    // do something
}