public class MyRunner extends BlockJUnit4ClassRunner {
    public MyRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
        Description description= describeChild(method);
        if (method.getAnnotation(Ignore.class) != null) {
            notifier.fireTestIgnored(description);
        } else {
            if (description.getAnnotation(Deprecated.class) != null) {
                System.out.println("name=" + description.getMethodName() + " annotations=" + description.getAnnotations());
            }
            runLeaf(methodBlock(method), description, notifier);
        }
    }
}