@Test
public void testEncoding() {
    String str = "\u0040";
    byte[] utf16 = str.getBytes(StandardCharsets.UTF_16);
    String utf16String = new String(utf16, StandardCharsets.UTF_16);
    assertEquals(str, utf16String);
}