public class BasicAuthSecurityHandler implements Handler {

    private ConstraintSecurityHandler securityHandler;

    @Override
    public ConstraintSecurityHandler getSecurityHandler() {
        return securityHandler;
    }

    public void setSecurityHandler(ConstraintSecurityHandler securityHandler) {
        this.securityHandler = securityHandler;
    }        

}