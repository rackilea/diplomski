// Every enum class extends Enum<ThisEnumClassName>. 
// Since we want T to be enum we must write it as "extends Enum"
// but Enum is also generic and require type of store parameters 
// so we need to describe it as Enum<T> which finally gives us - T extends Enum<T>
static <T extends Enum<T>> T reverse(String name, Class<T> clazz) {
    for (T t : clazz.getEnumConstants())
        if (t.name().equals(name))
            return t;
    return null;
}