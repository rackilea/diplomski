HashMap bugs = (HashMap)bugzillaObject; 
for( Object key : bugs.keySet() )
{

    Object value = bugs.get( key );
    Object[] valueArray = (Object[])value;
    for( Object v : valueArray )
    {

        HashMap L = (HashMap)v;
        for( Object key1 : L.keySet() )
        System.out.println( "Key " + "= "+key1  + ", value " + "= "+ L.get(key1) );
    }
}