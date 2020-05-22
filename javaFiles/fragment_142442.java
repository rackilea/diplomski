@Test
public void testSanitizeFilename() {
    PowerMock.mockStatic(FilenameUtils.class);
    EasyMock.expect(FilenameUtils.getExtension(anyString())).andReturn("jpeg").anyTimes();
    EasyMock.expect(FilenameUtils.getBaseName(anyString())).andReturn("jpeg").anyTimes();
    PowerMock.replayAll();

    for (Map.Entry<String, String> entry : fileUrls.entrySet()) {
        System.out.println("KEY: " + entry.getKey());
        String result = FileUtil.sanitizeFilename(entry.getKey(), entry.getValue());
        assertEquals(result, entry.getValue());     
        PowerMock.verifyAll();
    }
}