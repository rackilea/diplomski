public static class WrapperRunnableFunction extends BaseFunction {
    Runnable runnable;
    WrapperRunnableFunction(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public Object call(Context cx, Scriptable scope, Scriptable thisObj, java.lang.Object[] args) {
        runnable.run();
        return null;
    }
}