// exception handling is not shown
final String dn = ....;
final byte[] password = ....;
final BindRequest bindRequest = new SimpleBindRequest(dn,password);
final LDAPConnection ldapConnection = new LDAPConnection(hostname,port);
final BindResult bindResult = ldapConnection.bind(bindRequest);
final ResultCode resultCode = bindResult.getResultCode();
if(resultCode.equals(ResultCode.SUCCESS))
{
    // user is authenticated
}
ldapConnection.close();