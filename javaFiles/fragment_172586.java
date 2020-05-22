try {
    Field field = String.class.getDeclaredField("value");
    field.setAccessible(true);
    char[] value = (char[]) field.get(string);
    value[0] = Character.toLowerCase(value[0]);
} catch (IllegalAccessException e) {
    e.printStackTrace();
} catch (NoSuchFieldException e) {
    e.printStackTrace();
}