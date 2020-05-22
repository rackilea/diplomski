package foo.bar.test;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.JUnit4;
import org.junit.runners.model.InitializationError;

public class MyRunner extends Runner {

    private final Runner runner;

    public MyRunner(final Class<?> klass) throws InitializationError {
        super();
        this.runner = new JUnit4(klass);
    }

    @Override
    public Description getDescription() {
        return runner.getDescription();
    }

    @Override
    public void run(final RunNotifier notifier) {
        for (Description description : runner.getDescription().getChildren()) {
            notifier.fireTestStarted(description);
            try {
                // here it is possible to get annotation:
                // description.getAnnotation(annotationType)
                if (MyConfiguration.shallExecute(description.getClassName(), description.getMethodName())) {
                    runner.run(notifier);
                }
            } catch (Exception e) {
                notifier.fireTestFailure(new Failure(description, e));
            }
        }
    }

}