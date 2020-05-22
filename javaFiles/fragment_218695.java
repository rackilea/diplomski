Map obj1 = new HashMap();
  obj1.put("key1", 1);
  obj1.put("key2", false);
  obj1.put("key3", 3.94f);


Map<Object, Object> obj2 = obj1;

Map<String, String> obj = new HashMap<String,String>();

for (Object obj_Entry : obj1.entrySet()) {
    Map.Entry entry = (Map.Entry) obj_Entry; // This will Work Fine all Time. 
    obj.put(entry.getKey().toString(), entry.getValue().toString());

}