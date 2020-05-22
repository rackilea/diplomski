static <K,V> void debugPut(HashMap<K,V> m, K k, V v) {
    if(m.isEmpty()) debug(m);
    m.put(k, v);
    debug(m);
}
private static <K, V> void debug(HashMap<K, V> m) {
    for(Field f: FIELDS) try {
        System.out.println(f.getName()+": "+f.get(m));
    } catch(ReflectiveOperationException ex) {
        throw new AssertionError(ex);
    }
    System.out.println();
}
static final Field[] FIELDS;
static {
    String[] name={ "table", "size", "threshold" };
    Field[] f=new Field[name.length];
    for (int ix = 0; ix < name.length; ix++) try {
        f[ix]=HashMap.class.getDeclaredField(name[ix]);
    }
    catch (NoSuchFieldException ex) {
        throw new ExceptionInInitializerError(ex);
    }
    AccessibleObject.setAccessible(f, true);
    FIELDS=f;
}