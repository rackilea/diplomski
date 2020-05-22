@Test
public void testJsonToMap() {
    String data = "{\"name\":\"MyMobile\",\"category\":\"cellphone\",\"details\":{\"displayAspectRatio\":\"97:3\",\"audioConnector\":\"none\",\"motherBoard\":{\"Rom\":\"256GB\",\"Ram\":\"8GB\",\"Battery\":\"400mAH\"}}}";
    Gson gson = new GsonBuilder().create();
    Map jsonMap = gson.fromJson(data, Map.class);
    System.out.println(jsonMap);

    Sep2019JavaTest test = new Sep2019JavaTest();
    Map opMap = test.toMap(jsonMap, new HashMap<String, Object>(), "");
    System.out.println(opMap);
}

private Map toMap(Map ipMap, Map opMap, String parentKey) {
    if (ipMap != null && !ipMap.isEmpty()) {
        ipMap.forEach((k, v) -> {
            String key = parentKey.isEmpty() ? k.toString() : parentKey.concat(".").concat(k.toString());
            if (v.getClass() == LinkedTreeMap.class) {
                toMap((Map) v, opMap, key);
            } else {
                opMap.put(key, v);
            }

        });
    }
    return opMap;
}

//Output
//{details.motherBoard.Rom=256GB, details.motherBoard.Battery=400mAH, name=MyMobile, category=cellphone, details.audioConnector=none, details.motherBoard.Ram=8GB, details.displayAspectRatio=97:3}