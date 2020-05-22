public class JSONCopy extends JSONObject {

    public static JSONObject hashMap2JSONObject(Map copyFrom) throws JSONException {
        JSONObject newJson = new JSONObject();
        Map<?, ?> contentsTyped = (Map<?, ?>) copyFrom;
        for (Map.Entry<?, ?> entry : contentsTyped.entrySet()) {
            String key = (String) entry.getKey();
            if (key == null) {
                throw new NullPointerException("key == null");
            }
            newJson.put(key, wrap(entry.getValue()));
        }

        return newJson;
    }

    public static Object getJSONArray(Object o) throws JSONException {
        JSONArray newValue = new JSONArray();
        if (!o.getClass().isArray()) {
            throw new JSONException("Not a primitive array: " + o.getClass());
        }
        final int length = Array.getLength(o);
        for (int i = 0; i < length; ++i) {
            newValue.put(wrap(Array.get(o, i)));
        }

        return newValue;
    }

    public static Object wrap(Object o) {
        if (o == null) {
            return NULL;
        }
        if (o instanceof JSONArray || o instanceof JSONObject) {
            return o;
        }
        if (o.equals(NULL)) {
            return o;
        }
        try {
            if (o instanceof Collection) {
                return new JSONArray((Collection) o);
            } else if (o.getClass().isArray()) {
                return getJSONArray(o);
            }
            if (o instanceof Map) {
                return hashMap2JSONObject((Map) o);
            }
            if (o instanceof Boolean ||
                    o instanceof Byte ||
                    o instanceof Character ||
                    o instanceof Double ||
                    o instanceof Float ||
                    o instanceof Integer ||
                    o instanceof Long ||
                    o instanceof Short ||
                    o instanceof String) {
                return o;
            }
            if (o.getClass().getPackage().getName().startsWith("java.")) {
                return o.toString();
            }
        } catch (Exception ignored) {
        }
        return null;
    }
}