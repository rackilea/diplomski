@Rule
public TemporaryFolder rootFolder = new TemporaryFolder();

@Test
public void shouldCreateChildFile() throws Exception {
    File myFolder = rootFolder.newFolder("my-folder");

    File myFile = new File(myFolder, "my-file.txt");
}