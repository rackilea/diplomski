public <T extends Object> void processMap(Map<String, List<T>> map) {
}

public void processList(List<? extends Object> list) {
}

public void f() {
    List<String> list = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();

    processList(list); // OK
    processMap(map); // OK now
    processMap(new HashMap<String, List<Integer>>()); // this is OK too
}