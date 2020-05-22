public static void printJsonObject(JSONObject jsonObj) {

        for (Object key : jsonObj.keySet()) {
            String keyStr = (String) key;
            Object keyvalue = jsonObj.get(keyStr);

            if (keyvalue instanceof JSONObject) {
                printJsonObject((JSONObject) keyvalue);
            } else if (keyvalue instanceof JSONArray) {
                JSONArray array = (JSONArray) keyvalue;
                for (int i = 0; i < array.length(); i++) {
                    printJsonObject((JSONObject) array.get(i));
                }

            } else {
                System.out.println(keyStr + ", " + keyvalue);
            }
        }
    }