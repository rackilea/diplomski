String str = "{\"fruit\": {\"weight\":\"29.01\", \"texture\":null}, \"status\":\"ok\"}";
    JSONObject jsonObj = JSONObject.fromObject(str);
    try
    {
        // Contains the above string

        ObjectMapper mapper = new ObjectMapper();
        PojoClass p = mapper.readValue(jsonObj.toString(), new TypeReference<PojoClass>()
        {
        });

        System.out.println("w.weight = " + p.getFruit().getWeight());
    }
    catch (Throwable throwable)
    {
        System.out.println(throwable.getMessage());
    }