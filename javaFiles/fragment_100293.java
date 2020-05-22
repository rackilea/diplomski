public static void main(String[] args) throws IOException {
        String originalJson = "{\"empNo\":\"2390\",\"empName\":\"JAMES\",\"projects\":{\"projectId\":209,\"projectName\":\"Z560\"}}";
        try {
            JSONObject jsonObject = new JSONObject(originalJson);
            Map<String, Object> map = getMap(jsonObject);
            System.out.println("My Old Map => " + map);

            Map<String, Object> newMap = new HashMap<String, Object>();

            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getKey().equals("projects")) {
                    Map<String, Object> projectMap = (Map<String, Object>) entry.getValue();
                    for (Map.Entry<String, Object> entry1 : projectMap.entrySet()) {
                        newMap.put(entry1.getKey(), entry1.getValue());
                    }
                } else {
                    newMap.put(entry.getKey(), entry.getValue().toString());
                }
            }

            JSONObject jsonObject1 = new JSONObject(newMap);
            System.out.println("My New Map => " + newMap);
            System.out.println("Expected Json String => " + jsonObject1.toString());

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static Map getMap(JSONObject object) {
        Map<String, Object> map = new HashMap<String, Object>();

        Object jsonObject = null;
        String key = null;
        Object value = null;

        try {
            Iterator<String> keys = object.keys();
            while (keys.hasNext()) {

                key = null;
                value = null;

                key = keys.next();

                if (null != key && !object.isNull(key)) {
                    value = object.get(key);
                }

                if (value instanceof JSONObject) {
                    map.put(key, getMap((JSONObject) value));
                    continue;
                }

                if (value instanceof JSONArray) {
                    JSONArray array = ((JSONArray) value);
                    List list = new ArrayList();
                    for (int i = 0 ; i < array.length() ; i++) {
                        jsonObject = array.get(i);
                        if (jsonObject instanceof JSONObject) {
                            list.add(getMap((JSONObject) jsonObject));
                        } else {
                            list.add(jsonObject);
                        }
                    }
                    map.put(key, list);
                    continue;
                }

                map.put(key, value);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return map;
    }