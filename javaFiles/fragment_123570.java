@SuppressWarnings("unused")
@Test
public void verifySameStringReturnedWithExpectationsAPI(@Mocked Duplicator dup) throws Exception {
    new Expectations() {{
        dup.duplicate(anyString);
        result = new Delegate<String>() { String delegate(String str) { return str; }};
    }};

    assertEquals("test", dup.duplicate("test"));
    assertEquals("delegate did it", dup.duplicate("delegate did it"));
}