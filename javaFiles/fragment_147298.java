JSONObject jsonObject = new JSONObject();
JSONArray array = new JSONArray();
for(int i=0;i<10;i++){
    JSONObject obj = new JSONObject();
    obj.put("engine", "mkyong.com");
    obj.put("browser", i);
    obj.put("platform", i);

    //if you are using JSON.simple do this
    array.add(obj);

    //and if you use json-jena
    array.put(obj);
}
jsonObject.put("MyArray" , array);

System.out.print(jsonObject);