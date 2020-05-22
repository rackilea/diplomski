class Wrapper {
    private OriginalClass originalObject;

    <T> T getVariable(String name, Class<T> varClass) {
        return (T) originalObject.getVariable(name);
    }
}