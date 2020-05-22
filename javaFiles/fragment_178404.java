ExecutorService service = Executors.newFixedThreadPool(1);
AuthenticationContext context = null;
try {
    context = new AuthenticationContext("https://login.microsoftonline.com/" + "TENANT_ID", false, service);
    Future<AuthenticationResult> future = context.acquireToken("https://graph.microsoft.com", "client_id", "username", "password",null);
    System.out.println( future.get().getAccessToken());
} catch (InterruptedException e) {
    e.printStackTrace();
} catch (ExecutionException e) {
    e.printStackTrace();
} catch (MalformedURLException e) {
    e.printStackTrace();
}finally {
    service.shutdown();
}