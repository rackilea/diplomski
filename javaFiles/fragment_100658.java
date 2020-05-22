public class LoggedUserListener implements
        ApplicationListener<AuthenticationSuccessEvent> {

    @Autowired
    private HttpSession session;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        session.setAttribute("key", "value");

    }

}