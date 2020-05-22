public class LogonHandler implements Handler {
    private final CountDownLatch loginLatch = new CountDownLatch (1);

    private boolean callbackResults;

    public void serverResponseCallback(boolean result) {
        callbackResults = result;
        loginLatch.countDown ();
    }

    public boolean tryLogon(Credentials creds) throws InterruptedException {
        SomeServer server = new SomeServer(address);
        server.tryLogon (creds.getName (), creds.getPass ());
        loginLatch.await ();
        return callbackResults;
    }
}