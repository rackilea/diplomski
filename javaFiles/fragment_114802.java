private void initJAASandGSS() {
    LoginContext loginContext = null;               
    TextCallbackHandler cbHandler = new TextCallbackHandler();
    try {
        loginContext = new LoginContext("wSOXClientGSSJAASLogin", cbHandler);
        loginContext.login();
        mySubject = loginContext.getSubject();
    } catch (LoginException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    gssManager = GSSManager.getInstance();

    try {
        //TODO: LAMB: This name should be got from config / built from config / serviceIdentifier
        serverName = gssManager.createName("HTTP/app-srv.acme.com@ACME.COM", null);
        Oid krb5Oid = new Oid("1.2.840.113554.1.2.2");
    } catch (GSSException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();        
    }
}

private String getGSSwJAASServiceToken()  {

    byte[] token = null;
    String encodedToken = null;

    token = Subject.doAs(mySubject, new PrivilegedAction<byte[]>(){
        public byte[] run(){
            try{

                System.setProperty("javax.security.auth.useSubjectCredsOnly","true");
                GSSContext context = gssManager.createContext(serverName,
                    krb5Oid,
                    null,
                    GSSContext.DEFAULT_LIFETIME);

                context.requestMutualAuth(false);
                context.requestConf(false);
                context.requestInteg(true);

                byte[] ret = new byte[0];           
                ret = context.initSecContext(ret, 0, ret.length);

                context.dispose();

                return ret;

            } catch(Exception e){
                Log.log(Log.ERROR, e);
                throw new otms.util.OTMSRuntimeException("Start Client (Kerberos) failed, cause: " + e.getMessage());
            }
        }
    });

    encodedToken = Base64.getEncoder().encodeToString(token);
    return encodedToken;
}