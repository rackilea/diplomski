public class MyAction implements SessionAware {
    private Map<String,Object> session;

    public void setSession(Map<String,Object> session){ 
        this.session = session;
    }
}