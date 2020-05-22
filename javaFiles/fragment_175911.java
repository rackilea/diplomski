List<InformationObject> doMerge()
{
  Map<String, List<InformationObject>> map = new HashMap<>();
  addData(map, ds1);
  addData(map, ds2);
  addData(map, ds3);
  addData(map, ds4);

  List<InformationObject> result = new ArrayList<>();
  for(List<InformationObject> ios: map.values())
  {
    InformationObject io = mergeObjects(ios);
    result.add(io);
  }
  return result;
}

private void addData(Map<String, List<InformationObject>> map, Datasource ds)
{
   for(InformationObject io : ds...)
   {
     String id = io.getId();
     List<InformationObject> list = map.get(id);
     if(list == null) list = new ArrayList<>();
     list.add(io);
   }
}