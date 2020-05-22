static final Map<Class<?>,Class<?>> PRIMITIVE2WRAPPER;
static {
    Map<Class<?>,Class<?>> p2w=new HashMap<>();
    p2w.put(boolean.class, Boolean.class);
    p2w.put(byte.class, Byte.class);
    p2w.put(short.class, Short.class);
    p2w.put(char.class, Character.class);
    p2w.put(int.class, Integer.class);
    p2w.put(long.class, Long.class);
    p2w.put(float.class, Float.class);
    p2w.put(double.class, Double.class);
    PRIMITIVE2WRAPPER=Collections.unmodifiableMap(p2w);
}
static boolean canReturn(Method m, Object value) {
    Class<?> rt=m.getReturnType();
    if(value==null) return !rt.isPrimitive();
    Class<?> act=value.getClass();
    if(rt==act) return true;
    return rt.isPrimitive()? PRIMITIVE2WRAPPER.get(rt)==act: rt.isAssignableFrom(act);
}