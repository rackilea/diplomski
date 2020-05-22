public abstract class CleaningTestRunner extends BlockJUnit4ClassRunner {
    protected abstract void cleanupAfterAllTestRuns();

    private static long TEST_CLASSES_AMOUNT;
    private static long TEST_RUNS_FINISHED = 0;
    private static boolean CLASSES_COUNTED = false;

    static {
        while (!CLASSES_COUNTED) {
            try {
                Field f = ClassLoader.class.getDeclaredField("classes");
                f.setAccessible(true);

                Vector<Class> classes = (Vector<Class>) f.get(CleaningTestRunner.class.getClassLoader());
                TEST_CLASSES_AMOUNT = 0;
                for (Class<?> klass : classes) {
                    if (klass.isAnnotationPresent(RunWith.class)) {
                        if (CleaningTestRunner.class.isAssignableFrom(klass.getAnnotation(RunWith.class).value())) {
                            for (Method method : klass.getMethods()) {
                                if (method.isAnnotationPresent(Test.class)) {
                                    ++TEST_CLASSES_AMOUNT;
                                    break;
                                }
                            }
                        }
                    }

                }

                CLASSES_COUNTED = true;
            } catch (Exception ignored) {

            }
        }
    }

    public CleaningTestRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    public void run(RunNotifier notifier) {
        notifier.addListener(new TestCleanupListener());
        super.run(notifier);
    }

    private class TestCleanupListener extends RunListener {
        @Override
        public void testRunFinished(Result result) throws Exception {
            ++TEST_RUNS_FINISHED;

            if (TEST_RUNS_FINISHED == TEST_CLASSES_AMOUNT) {
                cleanupAfterAllTestRuns();
            }
        }
    }
}