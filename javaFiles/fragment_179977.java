Map<String,Consumer<Object[]>> methods = new HashMap<>();

methods.put (USE_CASE_ONE, param -> ip.method1(param));
methods.put (USE_CASE_TWO, param -> ip.method2(param));
...

public void handle(String s, String param) {
    methods.get(s).accept(new Object[]{param});
}