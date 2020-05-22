private static Map map = new HashMap();

public Foo getFoo(String page) {
    if (!map.containsKey(page)) {
        map.put(page, new Foo());
    }
    return (Foo) map.get(page);
}

public void setFoo(String page, Foo foo) {
    map.put(page, foo);
}