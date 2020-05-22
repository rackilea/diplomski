private List<HashMap<String, Object>> getJsonObjectsWithTempGreaterThan(JsonPath path, float degrees) {
        List<HashMap<String, Object>> desiredJsonObjects = new ArrayList<>();

        List<HashMap<String, Object>> list = path.getList("list");
        for (HashMap<String, Object> jsonObject : list) {
            HashMap<String, Object> mainElements = (HashMap<String, Object>) jsonObject.get("main");
            float temperature = (float) mainElements.get("temp");
            if (temperature > degrees) {
                desiredJsonObjects.add(jsonObject);
            }
        }

        return desiredJsonObjects;
    }