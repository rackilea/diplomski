public abstract class BaseAction extends ActionSupport 
                                  implements SessionAware {

    private Map<String,Object>  session;       
    private String token;

    public void setSession(Map<String,Object> session) {
        this.session = session;
    }
    public void setToken(String token) {
        // Retrieve the Token from the page, if any
        this.token = token;
    }
    public String getToken() {
        if (token==null){
            // Generates a new Token, only if it has not been passed from the JSP
            token = System.currentTimeMillis();
        }       
        return token;
    }
    public void setTokenSessionAttribute(String k, Object v){
        session.putSessionAttribute(getToken() + "_" + k,v);
    }
    public Object getTokenSessionAttribute(String k){
        return session.getSessionAttribute(getToken() + "_" + k);
    }


    public String execute(){
        return SUCCESS;
    }

    public String firstButtonClick() {
        setTokenSessionAttribute("FIRST_TEXT_FIELD", firstTextField);
        return SUCCESS;
    }

    public String secondButtonClick() {
        log.debug("Saved value was: " + getTokenSessionAttribute("FIRST_TEXT_FIELD"))
        return SUCCESS;
    }
    private String firstTextField; // with setter

}