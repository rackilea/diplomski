public class MyRunner extends Runner {

    private Context myContext;
    MyRunnerListener runnerListener;
    private final BlockJUnit4ClassRunner runner;

    public MyRunner(final Class<?> clazz) throws InitializationError {
        myContext = new Context();
        myContext.init();
        runnerListener = new MyRunnerListener(myContext);

        runner = new BlockJUnit4ClassRunner(clazz);
    }

    @Override
    public void run(final RunNotifier notifier) {
        notifier.addListener(runnerListener);
        runner.run(notifier);
    }

    @Override
    public Description getDescription() {
        return runner.getDescription();
    }

    public void filter(final Filter filter) throws NoTestsRemainException {
        runner.filter(filter);
    }
}