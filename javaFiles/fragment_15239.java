HashMap<String, Object> content = null;
    HashMap<String, String> result = new HashMap<String, String>();

    try {
        JsonFactory factory = new JsonFactory();
        ObjectMapper mapper = new ObjectMapper(factory);
        TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
        };
        content = mapper.readValue(jsonString, typeRef);

    } catch (Exception ex) {
        System.out.println("Exception : " + ex);
    } 
    // now content has everything inside
    for(String s : content.keySet()){
        Object obj = content.get(s);
        if(obj instanceof String){
            result.put(s, (String)obj);
        } else {
            HashMap<String,String> hm = (HashMap<String,String>)obj;
            for(String s2: hm.keySet()){
                result.put(s+"."+s2, hm.get(s2));
            }

        }
    }