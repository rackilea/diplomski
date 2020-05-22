static boolean canReturn(Method m, Object value) {
    Class<?> rt=m.getReturnType();
    if(value==null) return !rt.isPrimitive();
    Class<?> act=value.getClass();
    if(rt==act) return true;
    if(rt.isPrimitive()) try {
        return act.getDeclaredField("TYPE").get(null)==rt;
    } catch(ReflectiveOperationException | NullPointerException ex) {
        return false;
    }
    return rt.isAssignableFrom(act);
}