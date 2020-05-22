Map<Integer, List<YourObject>> cache = new HashMap<Integer, List<YourObject>>();
for (YourObject yo : yourObjectListArrayWhatever) {
  List<YourObject> list = cache.get(yo.getIntegerValue());
  if (list == null) {
    list = new ArrayList<YourObject>();
    cache.put(yo.getIntegerValue(), list);
  }
  list.add(yo);
}