public Object invokeExplosively(final Object target, final Object... params)
        throws Throwable {
    return new ReflectiveCallable() {
        @Override
        protected Object runReflectiveCall() throws Throwable {
            return method.invoke(target, params);
        }
    }.run();
}