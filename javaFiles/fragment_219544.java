@Test
public void test() {
    final String input = "abc test xy, tmy test 1, vks , csb";
    final String expected = "abc , tmy , vks , csb";
    final String got = replaceTestWordUpToComma(input);
    assertEquals(expected, got);
}

private String replaceTestWordUpToComma(String input) {
    return input.replaceAll("test[^,]+", "");
}