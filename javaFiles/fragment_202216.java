public <T extends Enum<T>> boolean checkValid(Class<T> enumType, String name){
    try {
        Enum.valueOf(enumType, name);
        return true;
    } catch(IllegalArgumentException e) {
        return false;
    }
}