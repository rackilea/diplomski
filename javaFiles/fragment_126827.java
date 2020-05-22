private Map<Class<? extends Parent>, Parent> map = new HashMap<>();

public void add(Parent p) {
    if (!map.containsKey(p.getClass()) {
        map.put(p.getClass(), p);
    }
}

public Parent get(Class<? extends Parent> clazz) {
    return map.get(clazz);
}