public class JSONMessage {
    public static <T extends JSONSerialisation> Collection<T> parseJSONMessage(Class<T> clazz, String json) {
        try {
            final JSONObject jsonObject = new JSONObject(json);
            final JSONArray lineItems = jsonObject.getJSONArray("Data");

            Collection<T> results = new ArrayList<T>(lineItems.size());

            for (final JSONElement elem: lineItems) {
                T result = clazz.newInstance();
                result.fromJSON(elem);
                results.add(result);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONMessage() {
        super();
    }
}