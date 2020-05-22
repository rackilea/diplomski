Map byType = new HashMap<Class<A>, A>();

void insertObject(Object v) {
   byType.put(v.getClass(), v);
}

Object getObject(Class c) {
    return byType.get(c);
}