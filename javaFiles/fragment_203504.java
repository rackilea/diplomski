@Component
public class SessionEndedListener implements ApplicationListener<SessionDestroyedEvent> {

    @Override
    public void onApplicationEvent(SessionDestroyedEvent event)
    {
        for (SecurityContext securityContext : event.getSecurityContexts())
        {
            Authentication authentication = securityContext.getAuthentication();
            YourPrincipalClass user = (YourPrincipalClass) authentication.getPrincipal();
            // do something
        }
    }

}