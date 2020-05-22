static boolean findValue(Object node, String value) {
    if (node instanceof String) {
        return node.equals(value);
    }
    else if (node instanceof JSONArray) {
        for (Object obj : (JSONArray)node) {
            if (findValue(obj, value)) {
                return true;
            }
        }
    }
    else if (node instanceof JSONObject) {
        for (Object obj : ((JSONObject)node).values()) {
            if (findValue(obj, value)) {
                return true;
            }
        }
    }
    return false;
}