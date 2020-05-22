private Cache<Integer,Object> cache = CacheBuilder.newBuilder().SomeConfig.build();
private Multimap<Integer,Object> multimap = HashMultimap<Integer, Object>.create();
private AtomicInteger atomicid = new AtomicInteger(0);

public void putInMultimap(int id, Object obj) {
   int mapid = atomicid.addAndGet(1);
   cache.put(mapid,obj);
   multimap.put(id,mapid);
}
public List<Object> getFromMultimap(int id) {
   Set<Integer> mapids = multimap.get(id);
   List<Object> list = new ArrayList<Object>();
   for (int i : mapids) {
      list.add(cache.getIfPresent(i));
   }
   return list;
}