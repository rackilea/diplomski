Collection<Object> objectCollection = null;
if (Collection.class.isAssignableFrom(object.getClass())) {
    objectCollection = (Collection<Object>) object;
} else if (object.getClass().isArray()) {
    objectCollection = Arrays.asList((Object[]) object);
} else {
    // do something else
}
if (objectCollection != null) {
    int index = 0;
    for (Object item : objectCollection) {
        doWork(index); // See note on question, slightly odd not using `item` here
                       // and not incrementing index in loop
    }
}