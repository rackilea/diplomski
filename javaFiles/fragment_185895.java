ArrayList<HashMap<String,String>> listMap =  new ArrayList<HashMap<String, String>>();
HashMap<String,String> map1 =new HashMap<String, String>();
map1.put("title","Amdroid1");
HashMap<String,String> map2 =new HashMap<String, String>();
map2.put("title","Amdroid2");
HashMap<String,String> map3 =new HashMap<String, String>();
map3.put("title","Amdroid3");
HashMap<String,String> map4 =new HashMap<String, String>();
map4.put("title","Amdroid4");
HashMap<String,String> map5 =new HashMap<String, String>();
map5.put("title","Amdroid5");

listMap.add(map1);
listMap.add(map2);
listMap.add(map3);
listMap.add(map4);
listMap.add(map5);

ArrayList<String> listString = new ArrayList<String>();
for(HashMap<String,String> row : listMap){
    listString.add(row.get("title"));
}

String[] array = listString.toArray(new String[listString.size()]);
System.out.print("Lenght "+array.length);