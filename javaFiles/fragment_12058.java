@ParameterizedTest
@CsvSource("abc, 123, foo; bar")
void test(String column1, int column2, @ConvertWith(StringArrayConverter.class) String[] column3) {
    assertEquals(column1, "abc");
    assertEquals(column2, 123);
    assertEquals(column3[0], "foo");
    assertEquals(column3[1], "bar");
}