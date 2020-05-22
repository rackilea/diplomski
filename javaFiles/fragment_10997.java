Map<String,Object> map = new HashMap<String,Object>(); //Object is containing String
Map<String,String> newMap =new HashMap<String,String>();
for (Map.Entry<String, Object> entry : map.entrySet()) {
       if(entry.getValue() instanceof String){
            newMap.put(entry.getKey(), (String) entry.getValue());
          }
 }