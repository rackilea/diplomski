List<HashMap<String, Object>> list = resp.getBody().jsonPath().getList("list");
for (HashMap<String, Object> jsonObject : list) {
    /**
    * Now, in order to get temperature, we have to get access to `main` element in JSON and then get access to the temperature
    **/
    HashMap<String, Object> mainElements = (HashMap<String, Object>) jsonObject.get("main");
    //No we have JSONObject as HashMap. We can access any temperature
    float temperature = (float) mainElements.get("temp");
    System.out.println(temperature);
}