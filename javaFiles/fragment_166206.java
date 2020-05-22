@Test
public void testHtmlParseSuccess() throws IOException {        
    assertEquals("this is a parsed html", classToTest.parse(html) ) //will return true, test will pass
}

@Test
    public void testHtmlParseSuccess() throws IOException {        
        assertEquals("this is a wrong answer", classToTest.parse(html) ) //will return false, test will fail
    }