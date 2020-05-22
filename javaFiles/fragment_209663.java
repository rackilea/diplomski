@Async
public void test1(String param1) {
    test2(param1, null);
}

private void test2(String param1, String param2) {
    test3(param1, param2, null);
}

private void test3(String param1, String param2, String param3) {
    // do something
}