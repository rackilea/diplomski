for (Field field : this.getClass().getDeclaredFields()) {
    field.setAccessible(true);
    if (field.getType() != String.class) {
        continue;
    }
    String value = (String) field.get(this);

    if (value.equals("N")) {
        if (!errors.containsKey(field.getName())) {
            errors.put(field.getName(), value);
        }
    }
}