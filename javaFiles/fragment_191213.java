public class MyTimerGui extends AbstractTimerGui {
    // usually has at least the following 3 functions:

    @Override
    public TestElement createTestElement() {
    }

    @Override
    public void modifyTestElement(TestElement timer) { 
    }

    @Override
    public void configure(TestElement el) {
    }
}

public class MyTimer extends AbstractTestElement implements Timer {

    long delay() {
        return someDelayOfYourChoice;
    }

    // you may need some other functions, e.g. running on test start or sample start
}