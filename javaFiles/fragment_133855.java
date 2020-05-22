Configuration con = // get the org.hibernate.cfg.Configuration
for(Iterator<PersistentClass> itpc = con.getClassMappings();itpc.hasNext();)
{
    PersistentClass pc = itpc.next();
    System.out.println(pc.getEntityName() + ", " + pc.getNodeName());
    System.out.println("Identifier(s):");
    Property idpy = pc.getIdentifierProperty();
    for(Iterator<?> itpy = idpy.getColumnIterator();itpy.hasNext();)
    {
        Object o = itpy.next();
        if(o instanceof Column)
        {
            Column c = (Column)o;
            System.out.println(c.getName());
        }
    }
}