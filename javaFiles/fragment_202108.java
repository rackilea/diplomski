if (objfac instanceof javax.jms.ConnectionFactory) {
    @SuppressWarnings("unchecked") // The environment is supposed to use String keys only
    Map<String, Object> env = null;
    try {
       env = (Map<String, Object>)ctx.getEnvironment();
    } catch (javax.naming.OperationNotSupportedException ex) {}
    if(env != null && env.containsKey(Context.SECURITY_PRINCIPAL)) {
        String username = (String)env.get(Context.SECURITY_PRINCIPAL);
        String password = (String)env.get(Context.SECURITY_CREDENTIALS);
        return ((javax.jms.ConnectionFactory) objfac).createConnection(username, password);                
    }
    else {
        return ((javax.jms.ConnectionFactory) objfac).createConnection();
    }
}