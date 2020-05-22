public static <T> T createObjectFrom(Class<T> clazz, Entity source){
    T obj = null;
    Map<String,Object> props = source.getProperties();
    Iterator<Map.Entry<String,Object>> it = props.entrySet().iterator();
    if (props.size() > 1){
        if (clazz == List.class){
            throw new RuntimeException("Not yet implemented");
        } else if (clazz == Map.class){
            throw new RuntimeException("Not yet implemented");
        } else {
            obj = createPOJOFrom(clazz, createMapFromEntity(source));
        }
    } else if (props.size() == 1) {
        Map.Entry<String,Object> entry = it.next();
        Object value = entry.getValue();
        if (clazz.isPrimitive()){
            obj = (T) value;
        } else if (clazz == String.class){
            String prop = String.valueOf(value);
            obj = (T) prop;
        } else if (clazz == Number.class || clazz == Long.class || clazz == Integer.class){
            Long prop = Long.valueOf(String.valueOf(value));
            obj = (T) prop;
        } else if (clazz == Boolean.class){
            Boolean prop = Boolean.valueOf(String.valueOf(value));
            obj = (T) prop;
        }
    } else {
        // empty
    }
    return obj;
}