public void MyTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void noSystemExit() {
        //passes
    }

    @Test
    public void systemExitWithArbitraryStatusCode() {
        exit.expectSystemExit();
        System.exit(0);
    }

    @Test
    public void systemExitWithSelectedStatusCode0() {
        exit.expectSystemExitWithStatus(0);
        System.exit(0);
    }
}