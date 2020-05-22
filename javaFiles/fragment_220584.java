public class UserSessionFactoryBean extends AbstractFactoryBean<UserSession> {

    @Override
    public Class<?> getObjectType() {
        return UserSession.class;
    }

    @Override
    protected UserSession createInstance() throws Exception {
        HttpSession session = WebContext.current().getSession();
        return (UserSession) session.getAttribute("userSession");   
    }

}