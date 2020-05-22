@SuppressWarnings("unchecked")
public static <T> T getValueForKey(JsonElement data, String key, Class<T> clazz) throws IllegalArgumentException {
    JsonElement element = data.getAsJsonObject().get(key);

    if (Integer.class.equals(clazz)) {
        return (T) new Integer(element.getAsInt());
    } else if (Double.class.equals(clazz)) {
        return (T) new Double(element.getAsInt());
    } else if (Boolean.class.equals(clazz)) {
        return (T) new Boolean(element.getAsBoolean());
    } else if (String.class.equals(clazz)) {
        return (T) element.getAsString();
    }

    throw new IllegalArgumentException("Could not get value of type: " + clazz.getSimpleName());
}