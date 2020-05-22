Criteria c = s.createCriteria(College.class,"clg");
c.createCriteria("students", "s");
c.add(Restrictions.eq("id",new Integer(1)));
c.add(Restrictions.eq("s.id", new Integer(1)));

ProjectionList properties = Projections.projectionList();
properties.add(Projections.property("name"));
properties.add(Projections.property("s.name"));
c.setProjection(properties);

List l=c.list();
Iterator it=l.iterator();
while(it.hasNext())
{
    Object ob[] = (Object[])it.next();
    System.out.println(ob[0]+"--------"+ob[1]);
}