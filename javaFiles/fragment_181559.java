Map<String, Object> result = new HashMap<String, Object>();

for (int j=0 ; j<jsonarr2.size(); j++ )
{
    Map<String, Object> createmap = new HashMap<String, Object>();
    JSONObject jsonobj2 = (JSONObject) jsonarr2.get(j);
    Iterator<String> key2 = jsonobj2.keySet().iterator();
    while (key2.hasNext()) {
        String k2 = key2.next();
        createmap.put(k2, jsonobj2.get(k2));    
    }
    System.out.println("Print J:" + j + " CREATE MAP:" + createmap);
    result.put(Integer.toString(j),createmap);
}