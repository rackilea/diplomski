public final class ParentHook {

    @Before
    public void beforeScenario(Scenario myScenario) {

    }

    @After
    public void afterScenario() {
        if (your condition to stop the test) {
           //custom handle to stop the test
           myHandler.pleaseStop();
           Foo.runtime.getEventBus().send(new TestRunFinished(Foo.runtime.getEventBus().getTime()));
        }
    }
}