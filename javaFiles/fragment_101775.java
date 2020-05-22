Attributes attributes = dirContext.getAttributes( "", new String[]{"namingContexts"} );
Attribute attribute = attributes.get( "namingContexts" );
NamingEnumeration<?> all = attribute.getAll();
while(all.hasMore())
{
    String next = (String)all.next();
    System.out.println(next);
}