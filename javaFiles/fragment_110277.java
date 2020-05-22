@RunWith(MockitoJUnitRunner.class)
public class ReaderTest {

  @Rule
  public ExpectedException exception = ExpectedException.none(); // has to be public

  private YourReader subject = new YourReader();

  @Test(expect = FileNotFoundException.class)
  public void shouldThrowFNFException() {
    // given
    File nonExistingFile = new File("blabla.txt");

    // when
    subject.readList(nonExistingFile);
  }

  // ... OR ...

  @Test
  public void shouldThrowFNFExceptionWithProperMessage() {
    // given
    File nonExistingFile = new File("blabla.txt");

    exception.expect(FileNotFoundException.class);
    exception.exceptionMessage("your message here");

    // when
    subject.readList(nonExistingFile);
  }
}