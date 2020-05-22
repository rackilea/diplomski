@Rule
public TemporaryFolder folder = new TemporaryFolder();

@Test
public void testXYZ() {
    final File expected = new File("xyz.txt");
    final File output = folder.newFile("xyz.txt");
    TestClass.xyz(output);
    Assert.assertEquals(FileUtils.readLines(expected), FileUtils.readLines(output));
}