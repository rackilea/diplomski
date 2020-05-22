public class TestContextInjectionIT extends JUnit4CitrusTestRunner {
    @Test
    @CitrusTest
    public void contextInjection(@CitrusResource TestContext context) {
        context.setVariable("message", "Hello, I am a variable!");

        echo("${message}");

        String message = context.getVariable("message");
        log.info(message);
    }
}