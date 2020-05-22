class MethodAdapter implements TownyChatReplacerCallable {
    private final Method method;
    public MethodAdapter(Method m) {
        method = m;
    }
    @Override
    public String call(String match, String event) {
        try {
            return (String) method.invoke(null, match, event);
        } catch (Exception e) {
            e.printStackTrace();
            return "OMGZ";
        }
    }
}