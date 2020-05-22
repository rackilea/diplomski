public Map<String, Object> convert(Object object) {
    Map<String, Object> map = new HashMap<>();
    for (Field field : object.getClass().getDeclaredFields()) {
        field.setAccessible(true);
        try {
            if (isSimpleType(field.getType())) {
                map.put(field.getName(), field.get(object));
            } else {
                map.put(field.getName(), convert(field.get(object)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return map;
}