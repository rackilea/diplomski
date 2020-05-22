class MyClass implememts SomeInterface {

    @Override
    public int someMethod(int arg1, int arg2) {
        return staticMethod(arg1, arg2);
    }

    private static int staticMethod(int arg1, int arg2) {
        // TODO: do some useful stuff...
        return arg1 + arg2;
    }
}