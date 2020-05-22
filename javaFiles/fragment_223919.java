/**
 * Remove the account
 * 
 * @param ctx
 * @param dn
 * @throws NamingException
 */
public static void removeUser(LdapContext ctx, String dn) throws NamingException {
    ctx.unbind(dn); //that's all
}