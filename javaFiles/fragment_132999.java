List<Method> methods = new ArrayList<>();
for (Method m : sample.class.getDeclaredMethods()) {
    if (!m.isSynthetic()) {
        methods.add(m);
    }
}