static abstract class Parent<T extends ErrorVO> {
    public abstract void registerError(T e);
}

static class Child extends Parent<ASubclassOfErrorVO> {
    @Override
    public void registerError(ASubclassOfErrorVO e) {
    }
}