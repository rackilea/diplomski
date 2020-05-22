@RunWith(JUnit4.class)
public class SaveCsvTest {
  @Rule
  public TemporaryFolder testFolder = new TemporaryFolder();

  @Test
  public void savePlayerShouldWriteCsv() {
    File file = testFolder.newFolder("folder");
    SaveCsv saveCsv = new SaveCsv(file);
    InputStream stream = new FileInputStream(file);
    Reader reader = new InputStreamReader(
        stream, StandardCharsets.UTF_8);
    // compare contents of data
  }