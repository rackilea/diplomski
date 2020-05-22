List<String> idList;
List<ObjectWithID> objectList;

Map<String, ObjectWithID> helperMap=new HashMap<>();

//first O(n)
for (ObjectWithID o:objectList) {
  helperMap.put(o.ID, o);
}

int i=0;
//second O(n)
for (String id:idList) {
  objectList.set(i,helperMap.get(id));
  i++;
}