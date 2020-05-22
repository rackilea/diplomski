public static Type getType(int id) {

    for (Type type : Type.values()) {
        if (id == type.getId()) {
            return type;
        }
    }
    return null;
}