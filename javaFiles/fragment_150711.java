private Map<Class,Map<String,Superclass>> map = new HashMap<>();
void update(List<? extends Superclass> l) {
    l.stream().forEach(o -> put(o));
}

public void  put(Superclass obj) {
    String id = obj.getId();
    Map<String,Superclass> submap = map.get(obj.getClass());
    if(null == submap) {
        submap = new HashMap<>();
        map.put(obj.getClass(), submap);
    }
    submap.put(id, obj);
}

public Superclass get(Class clss, String id) {
    return Optional.ofNullable(map)
            .map(m -> m.get(clss))
            .map(m2 -> m2.get(id))
            .orElse(null);
}