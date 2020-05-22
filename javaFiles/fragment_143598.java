Query q = session.createQuery(sql); 
List<Object[]> li= (List<Object[]>)q.list();
for(Object[] ob: li)
{ 
user=ob[0].toString();
Pass=ob[1].toString();
}