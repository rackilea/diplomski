Iterator<String> aIt = a.iterator();
Iterator<String> bIt = b.iterator();
Iterator<String> cIt = c.iterator();

List<ObjectA> thislist = new ArrayList<ObjectA>();


// assumes all the lists have the same size
while(aIt.hasNext())
{
    Object A o = new ObjectA(aIt.next(), bIt.next(), cIt.next());
    thisList.add(o);
}