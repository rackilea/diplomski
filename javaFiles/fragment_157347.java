public class AccessLogHandler implements ApplicationListener<AbstractAuthenticationEvent>, LogoutHandler {

    @Autowired
    private SessionRegistry sessionRegistry;

    @Autowired
    private AccessLogService accessLogService;

    public void onApplicationEvent(AbstractAuthenticationEvent event) {
        if (event instanceof AuthenticationSuccessEvent || event instanceof InteractiveAuthenticationSuccessEvent) {
            Authentication authentication = event.getAuthentication();
            WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
            accessLogService.addAccessLog("IP: "  + details.getRemoteAddress(), authentication.getName(), details.getSessionId());           
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
            WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
            accessLogService.closeAccessLog(Collections.singletonList(details.getSessionId());
            SessionInformation si = sessionRegistry.getSessionInformation(details.getSessionId());
            if (si != null) {
                si.expireNow();
            }
    }
}