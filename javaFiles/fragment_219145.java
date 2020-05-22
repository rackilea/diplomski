public class HTTPKerberosHandler implements SOAPHandler<SOAPMessageContext> {

    private final String contextName;
    private final String servicePrincipal;
    private static Oid KRB5_MECH_OID = null;
    private static Oid SPNEGO_MECH_OID = null;
    private static Oid KERBEROS_V5_PRINCIPAL_NAME = null;
    final String className = this.getClass().getName();

    static {
        try {
            KERBEROS_V5_PRINCIPAL_NAME = new Oid("1.2.840.113554.1.2.2.1");
            KRB5_MECH_OID = new Oid("1.2.840.113554.1.2.2");
            SPNEGO_MECH_OID = new Oid("1.3.6.1.5.5.2");
        } catch (final GSSException ex) {
            System.out.println("Exception creating mechOid's: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public HTTPKerberosHandler(final String contextName, final String servicePrincipal) {
        this.contextName = contextName;
        this.servicePrincipal = servicePrincipal;
    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }

    @Override
    public void close(MessageContext context) {
        // No action
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        if (((Boolean) context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY))) {
            return handleRequest(context);
        } else {
            return handleResponse(context);
        }
    }

    private boolean handleRequest(SOAPMessageContext context) {
        byte[] token = getKerberosToken(contextName, servicePrincipal);

        HashMap<String, String> sendTransportHeaders = new HashMap<String, String>();
        sendTransportHeaders.put("Authorization", "Negotiate " + Base64.encode(token));
        context.put(com.ibm.websphere.webservices.Constants.REQUEST_TRANSPORT_PROPERTIES, sendTransportHeaders);

        return true;
    }

    private boolean handleResponse(SOAPMessageContext context) {
        logger.logInformation(className, "handleResponse", "Inbound response detected");
        return true;
    }

    public byte[] getKerberosToken(final String contextName, final String servicePrincipal) {

        try {
            LoginContext lc = getLoginContext(contextName);

            final Subject subject = lc.getSubject();

            byte[] token = (byte[]) Subject.doAs(subject, new PrivilegedExceptionAction() {
                @Override
                public Object run() throws PrivilegedActionException, GSSException {
                    final String methodName = "getKerberosToken/run";
                    final GSSManager manager = GSSManager.getInstance();

                    Set<Principal> principals = subject.getPrincipals();
                    Iterator it = principals.iterator();
                    String principalName = ((Principal) it.next()).getName();
                    logger.logInformation(className, methodName, "Using principal: [" + principalName + "]");

                    GSSName gssName = manager.createName(principalName, GSSName.NT_USER_NAME, KRB5_MECH_OID);
                    GSSCredential gssCred = manager.createCredential(gssName.canonicalize(KRB5_MECH_OID),
                            GSSCredential.DEFAULT_LIFETIME,
                            KRB5_MECH_OID,
                            GSSCredential.INITIATE_ONLY);

                    gssCred.add(gssName, GSSCredential.INDEFINITE_LIFETIME,
                            GSSCredential.INDEFINITE_LIFETIME,
                            SPNEGO_MECH_OID,
                            GSSCredential.INITIATE_ONLY);
                    logger.logInformation(className, methodName, "Client TGT obtained: " + gssCred.toString());

                    GSSName gssServerName = manager.createName(servicePrincipal, GSSName.NT_USER_NAME);

                    GSSContext clientContext = manager.createContext(gssServerName.canonicalize(SPNEGO_MECH_OID),
                            SPNEGO_MECH_OID,
                            gssCred,
                            GSSContext.DEFAULT_LIFETIME);

                    logger.logInformation(className, methodName, "Service ticket obtained: " + clientContext.toString());

                    byte[] token = new byte[0];
                    token = clientContext.initSecContext(token, 0, token.length);
                    clientContext.dispose();
                    return token;
                }
            });

            return token;
        } catch (PrivilegedActionException ex) {
            logger.logError(HTTPKerberosHandler.class.getName(), methodName, "PrivilegedActionException: " + ex.getMessage());
        } catch (Exception ex) {
            logger.logError(HTTPKerberosHandler.class.getName(), methodName, "Exception: " + ex.getMessage());
        }

        return null;
    }

    private LoginContext getLoginContext(String contextName) {

        LoginContext lc = null;
        try {
            lc = new LoginContext(contextName);

            lc.login();
        } catch (LoginException le) {
            logger.logError(HTTPKerberosHandler.class.getName(), methodName, "Login exception: [" + le.getMessage() + "]");
            le.printStackTrace();
        }

        return lc;
    }

}