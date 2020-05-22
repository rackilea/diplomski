Map<String, Map<String, Object>> objectMap = new LinkedHashMap<String,Map<String, Object>>();
Map<String, Object> map;
 while(rs.next()){
     if(objectMap.containsKey(rs.getString("Name"))){
        map = objectMap.get(rs.getString("Name"));
        map.put(rs.getString("Method"), rs.getInt("Value"));
    }
    else {
      map = new HashMap<String, Object>();
      map.put("Tag", 0);
      map.put("Plate", 0);
      map.put("Name", rs.getString("Name"));
      map.put(rs.getString("Method"), rs.getInt("Value"));
    }
    objectMap.put(rs.getString("Name"), map);
 }

return objectMap.values();