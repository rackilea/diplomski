public static void main(String[] args) {
    String[][] jsonInputs = new String[6][2];

    jsonInputs[0][0] = "Long-Object";
    jsonInputs[0][1] = "{ \"user_id\":{\"long\":876},\"client_id\":{\"int\":0},\"affinity\":[{\"try\":{\"long\":55787693},\"scoring\":{\"float\":0.19}},{\"try\":{\"long\":1763},\"scoring\":{\"float\":0.0114}}]}";

    jsonInputs[1][0] = "String-Object";
    jsonInputs[1][1] = "{ \"user_id\":{\"string\": \"876\"},\"client_id\":{\"int\":0},\"affinity\":[{\"try\":{\"long\":55787693},\"scoring\":{\"float\":0.19}},{\"try\":{\"long\":1763},\"scoring\":{\"float\":0.0114}}]}";

    jsonInputs[2][0] = "String";
    jsonInputs[2][1] = "{ \"user_id\": \"1267818821\" , \"filter\": { \"string\": \"hello\" } }";

    jsonInputs[3][0] = "Long";
    jsonInputs[3][1] = "{ \"user_id\": 1267818821 , \"filter\": { \"string\": \"hello\" } }";

    jsonInputs[4][0] = "Null";
    jsonInputs[4][1] = "{ \"user_id\": null , \"filter\": { \"string\": \"hello\" } }";

    jsonInputs[5][0] = "Not-Present";
    jsonInputs[5][1] = "{ \"filter\": { \"string\": \"hello\" } }";

    for (String[] json : jsonInputs) {
        System.out.println(json[0]);
        System.out.println(changeJsonString(json[1], "54321"));
        System.out.println();
    }
}

private static String changeJsonString(String originalResponse, String newId) {
    try {
        JSONObject root = new JSONObject(originalResponse);
        if (!root.isNull("user_id")) {
            Object userObj = root.get("user_id");
            if (userObj instanceof JSONObject) {
                JSONObject userId = (JSONObject) userObj;
                if (userId.has("long")) {
                    userId.put("long", Long.parseLong(newId));
                } else {
                    userId.put("string", newId);
                }
            } else if (userObj instanceof Number) {
                root.put("user_id", Long.parseLong(newId));
            } else {
                root.put("user_id", newId);
            }
        }
        return root.toString();
    } catch (JSONException e) {
        e.printStackTrace();
        return null;
    }
}