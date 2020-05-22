public class TestContextAccessIT extends JUnit4CitrusTestRunner {
    @Test
    @CitrusTest
    public void contextInjection() {
        variable("message", "Hello, I am a variable!");

        echo("${message}");

        run(new AbstractTestAction() {
            @Override
            public void doExecute(TestContext context) {
                String message = context.getVariable("message");
                log.info(message);
            }
        });      
    }
}