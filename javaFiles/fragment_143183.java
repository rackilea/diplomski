private static final Map<Class, Object> replacementForNull = new HashMap<>();
static {
    replacementForNull.put(String.class, "NOTHING");
    replacementForNull.put(Long.class, 1L);
}


Method reflectionMethodThatCanReturnNull = ...
T resultNotNull = (T) reflectionMethodThatCanReturnNull.invoke(anObject);
// If it's null, let's assign something assignable.
if (resultNotNull == null) {
    Class returnType = reflectionMethodThatCanReturnNull.getReturnType();
    resultNotNull = replacementForNull.get(returnType);
}