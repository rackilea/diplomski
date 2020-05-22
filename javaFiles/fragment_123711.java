public class TestMain {
    public static void main(String[] args) throws Exception {
        JSONObject requiredJSONObject = performJSONObject("Your JSONObject");
    }

    public static JSONObject performJSONObject(JSONObject inputObject) throws Exception {
        JSONObject resultObject = new JSONObject();
        Iterator iterator = inputObject.keys();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (inputObject.get(key) instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) inputObject.get(key);
                resultObject.put(getModifiedKey(key), performJSONObject(jsonObject));
            } else if (inputObject.get(key) instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) inputObject.get(key);
                resultObject.put(getModifiedKey(key), performJSONArray(jsonArray));
            } else {
                resultObject.put(getModifiedKey(key), inputObject.get(key));
            }
        }
        return resultObject;
    }

    public static JSONArray performJSONArray(JSONArray inputArray) throws Exception {
        JSONArray resultArray = new JSONArray();
        for (int i = 0; i < inputArray.length(); i++) {
            if (inputArray.get(i) instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) inputArray.get(i);
                resultArray.put(i, performJSONObject(jsonObject));
            } else if (inputArray.get(i) instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) inputArray.get(i);
                resultArray.put(i, performJSONArray(jsonArray));
            } else {
                resultArray.put(i, inputArray.get(i));
            }
        }
        return resultArray;
    }

    public static String getModifiedKey(String strn) {
        String[] r = strn.split("(?=\\p{Upper})");
        String result = "";
        for (String str : r)
            result += str.toLowerCase() + "_";
        return result.substring(0, result.length() - 1);
    }
}