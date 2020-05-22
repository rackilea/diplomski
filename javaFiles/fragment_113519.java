import org.junit.Rule;
import org.junit.rules.TestWatcher;

...

@Rule
public TestWatcher watcher = new TestWatcher() {
    @Override
    public Statement apply(Statement base, Description description) {           
        if (description.getMethodName().toLowerCase().contains("thisTestTakesLonger")) {
            return new FailOnTimeout(base, 600000); //10 minutes = 600000
        } else {
            return new FailOnTimeout(base, 300000); //5 minutes = 300000
        }  
    }
};