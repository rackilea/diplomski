public class SetupAuthTokenBeforeSuite extends TestDesignerBeforeSuiteSupport {

    @Override
    public void beforeSuite(TestDesigner designer) {
        designer.echo("Setting up authentication token");

        designer.http()
                .client(HttpTqaClient)
                .send()
                ...

        designer.http()
                .client(HttpTqaClient)
                .receive()
                .response(HttpStatus.OK)
                .messageType(MessageType.JSON)
                .extractFromHeader("Authorization", "header_token")
                .extractFromPayload("$.id_token", "payload_token");

        designer.action(new AbstractTestAction() {
            @Override public void doExecute(TestContext testContext) {
                testContext.getGlobalVariables().put("global_auth_token", "${payload_token}");
            }
        });
    }
}