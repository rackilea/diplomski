public static boolean hasValue(String value) throws IllegalAccessException {
    for(Field field : Attributes.class.getDeclaredFields()) {
        if(((String)field.get(Attributes.class)).equals(value)) {
            return true;
        }
    }
    return false;
}