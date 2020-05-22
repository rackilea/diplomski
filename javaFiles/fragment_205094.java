public static boolean dynamicIf(String a, String b, String c) {

    final String[] list = {"one", "two", ""};

    boolean value = true;

    if (!a.isEmpty()) {
        value &= a.equals(list[0]);
    }

    if(!b.isEmpty()) {
        value &= b.equals(list[1]);
    }

    if (!c.isEmpty()) {
        value &= c.equals(list[2]);
    }

    return value;
}