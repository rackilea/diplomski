public MyClass {
    private Map<String, Integer> map1;
    private Map<String, String> map2;
    // other properties

    private MyClass() {}

    public static MyClass withMap1(Map<String, Integer> map ) {
        MyClass c = new MyClass();
        c.map1 = map;
        return c;
    }
    public static MyClass withMap2(Map<String, String> map ) {
        MyClass c = new MyClass();
        c.map2 = map;
        return c;
    }
    // getters and setters
}