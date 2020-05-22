public class Container<T> {

    public String id;
    public List<T> content;
    public Object data;

    public static <T> Container<T> deserializeClass(String json, Class<? extends Container<T>> type) {
        return new Gson().fromJson(json, type);
    }
    public static <T> Container<T> deserializeType(String json, Type type) {
        return new Gson().fromJson(json, type);
    }

    public static <T> Container<T> deserialize(String json, Class<T> clazz) {
        Type type = TypeToken.getParameterized(Container.class,clazz).getType();
        return new Gson().fromJson(json, type);
    }
}