@Test
public void mockZipFile() throws Exception
{
    final ZipFile testZip = new ZipFile("test.zip");

    new NonStrictExpectations() {
        @Capturing @Injectable ZipFile mock;

        {
            mock.entries(); result = testZip.entries();

            mock.getInputStream((ZipEntry) any);
            result = new Delegate() {
                InputStream delegate(ZipEntry e) throws IOException {
                    return testZip.getInputStream(e);
                }
            };
        }
    };

    ZipFile zf = new ZipFile("non-existing");
    ZipEntry firstEntry = zf.entries().nextElement();
    InputStream content = zf.getInputStream(firstEntry);
    String textContent = new BufferedReader(new InputStreamReader(content)).readLine();

    assertEquals("test", textContent);
}