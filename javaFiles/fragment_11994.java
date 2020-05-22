//Initialize ConcurrentHashMap instance
ConcurrentHashMap<String, Integer> m = new ConcurrentHashMap<String, Integer>();

//Print all values stored in ConcurrentHashMap instance
for each (Entry<String, Integer> e : m.entrySet())
{
system.out.println(e.getKey()+"="+e.getValue());
}