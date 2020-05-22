Map<String,BiConsumer<String,List<String>>> methods = new HashMap<>();

methods.put (USE_CASE_ONE, (s,l) -> ip.method1(s,l));
methods.put (USE_CASE_TWO, (s,l) -> ip.method2(s,l));
...

public void handle(String s, String param) {
    methods.get(s).accept(someString,someListOfStrings);
}