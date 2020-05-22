JSONObject obj = new JSONObject();
    obj.put("key1", "value1");
    obj.put("key2", "value2");
    Iterator<String> keys = obj.keys();

    while(keys.hasNext()){
        System.out.println(keys.next());
    }