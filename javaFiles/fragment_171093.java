public static void main(String[] args) throws ParseException {

    String jsonString = "{\"a\": \"b\",\"features\": [{\"feature1\": \"value1\"}, {\"feature2\": \"value2\"}]}";
    JSONParser parser = new JSONParser();
    JSONObject jsonObj = (JSONObject) parser.parse(jsonString);

    JSONObject newJSON = new JSONObject();
    newJSON.put("feature3", "value3");

    appendToList(jsonObj, newJSON);

    System.out.println(jsonObj);
    }


private static void appendToList(JSONObject jsonObj, JSONObject toBeAppended) {

        JSONArray arr = (JSONArray) jsonObj.get("features");        
        arr.add(toBeAppended);
    }