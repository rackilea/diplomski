@Test
public void testIsEqualIgnoringWhitespace() {
    // leading and trailing spaces are ignored
    assertThat("m 2", equalToIgnoringWhiteSpace(" m 2 "));

    // all other spaces are collapsed to a single space
    assertThat("m 2", equalToIgnoringWhiteSpace("m     2"));

    // does not match because the single space in the expected string is not collapsed any further
    assertThat("m2", not(equalToIgnoringWhiteSpace("m 2")));
}