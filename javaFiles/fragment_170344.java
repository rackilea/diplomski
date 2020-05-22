private void convert(Class<?> load) {

    Field[] fields = load.getDeclaredFields();
    int i = 0;
    for (Field field : fields) {
        Class<?> type = field.getType();
        if (java.util.List.class.isAssignableFrom(type)) {
        }
    }
}