@Test
public void testUsingCustomIgnoringAllWhitespaceMatcher() {
    // leading and trailing spaces are ignored
    assertThat("m2", ignoresAllWhitespaces(" m 2 "));

    // intermediate spaces are ignored
    assertThat("m2", ignoresAllWhitespaces("m     2"));
}