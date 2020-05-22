private static void test(final Type type) {
    System.out.println(type);
    final Object value = fromJson("[\"foo\",\"bar\"]", type);
    System.out.println("-\t" + value);
    System.out.println("-\t" + toJson(value, type));
}