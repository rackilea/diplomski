class MyClass {
    public MyClass(String... x) {
        // for arrays
        // this constructor delegate call to the second one
        this(Arrays.asList(x));
    }
    public MyClass(List<String> x) {
        // for lists
        // all logic here
    }
}