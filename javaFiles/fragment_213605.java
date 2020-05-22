@RunWith(MockitoJUnitRunner.class)
public class ContactDetailRetrieverTest {

    private ContactDetailRetriever testSubject;

    @Mock
    private FileLinesReader fileLinesReader;

    @Test
    public void testMapOfContact() {
        when(fileLinesReader.readAllLines("contacts.txt"))
            .thenReturn(Arrays.asList("contactKey1", "contactValue1", "contactKeyA", "contactValueA"));
        Map<String, String> result = testSubject.mapOfContact();
        assertThat(result.size(), equalTo(2));
        assertThat(result.get("contactKey1"), equalTo("contactValue1"));
        assertThat(result.get("contactKeyA"), equalTo("contactValueA"));
    }

    @Before
    public void setup() throws Exception {
        testSubject = new ContactDetailRetriever("contacts.txt", fileLinesReader);
    }
}