private static String mapMyVal(String val) {
    switch (val) {
        case "foo":
            return "FOO_FOO";
        case "bar":
            return "BARR";
        default:
            throw new InvalidArgumentException();
    }
}