Hashtable env = new Hashtable();
env.put("java.naming.factory.initial",
             "com.sun.jndi.dns.DnsContextFactory");
DirContext ictx = new InitialDirContext( env );
Attributes attrs = ictx.getAttributes
                       ( hostName, new String[] { "MX" });
Attribute attr = attrs.get( "MX" );
if (( attr == null ) || ( attr.size() == 0 )) {
   attrs = ictx.getAttributes( hostName, new String[] { "A" });
   attr = attrs.get( "A" );
   if( attr == null )
         throw new NamingException
                  ( "No match for name '" + hostName + "'" );
}