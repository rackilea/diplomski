Iterator<A> it = (Iterator<A>) criteria.list().iterator();
while(it.hasNext())
{
obj = it.next();
list.add(obj);
}