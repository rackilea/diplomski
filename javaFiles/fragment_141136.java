public static MyEnum asMyEnum(String str) {
    for (MyEnum me : MyEnum.values()) {
        if (me.name().equalsIgnoreCase(str))
            return me;
    }
    return null;
}