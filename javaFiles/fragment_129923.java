public class YourListener implements ApplicationListener<HttpSessionDestroyedEvent> {

    public void onApplicationEvent(HttpSessionDestroyedEvent evt) {
        for (SecurityContext ctx : evt.getSecurityContexts() ) {
             Authentication auth = ctx.getAuthentication();
             Object principal = auth.getPrincipal();
             // Do your thing with the principal.
        }
    }
}