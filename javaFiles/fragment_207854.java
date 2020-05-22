Map<String, Object> resultMap = new Gson().fromJson(jsonString, new TypeToken<Map<String, Object>>() {
        }.getType());

        for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
            System.out.println(entry);
        }

        System.out.println(resultMap.get("temp"));
        Map<String, Object> mainMap = new Gson().fromJson(resultMap.get("main").toString(), new TypeToken<Map<String, Object>>() {
        }.getType());
        System.out.println("Temp: " + mainMap.get("temp"));