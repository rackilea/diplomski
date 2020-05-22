@Test
public void testMockStaticFinal() throws Exception {
    mockStatic(StaticService.class);
    String expected = "Hello altered World";
    expect(StaticService.sayFinal("hello")).andReturn("Hello altered World");
    replay(StaticService.class);

    String actual = StaticService.sayFinal("hello");

    verify(StaticService.class);
    assertEquals("Expected and actual did not match", expected, actual);

    // Singleton still be mocked by now.
    try {
        StaticService.sayFinal("world");
            fail("Should throw AssertionError!");
    } catch (AssertionError e) {
        assertEquals("\n  Unexpected method call sayFinal(\"world\"):", 
            e.getMessage());
    }
}