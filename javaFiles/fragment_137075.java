public class Welcome extends ActionSupport implements SessionAware {

    private Map<String,Object> session;    
    public void setSession(Map<String,Object> session) {
        this.session = session;
    }

    private String user;
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public String execute() {
        session.put("user1", user);    
        return SUCCESS;
    }
}