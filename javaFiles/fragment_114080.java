for (HashMap<String, Object> jsonObject : objects) {
    HashMap<String, Object> mainElements = (HashMap<String, Object>) jsonObject.get("main");
    //No we have JSONObject as HashMap. We can access any temperature
    float temperature = (float) mainElements.get("temp");
    System.out.println(temperature);
}