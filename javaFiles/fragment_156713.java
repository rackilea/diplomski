class TypeChecker<T> {
    private Class<T> ofType;

    TypeChecker(Class<T> ofType) {
        this.ofType = ofType;
    }

    boolean isGood(Object obj) {
        return ofType.isInstance(obj);
    }
}