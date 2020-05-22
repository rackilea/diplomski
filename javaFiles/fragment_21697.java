public static String getString(JSONObject object, String tag, String defString) {
    if (object.has(tag))
        return object.getString(tag);
    else
        return defString;
}