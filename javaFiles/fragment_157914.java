@RunWith(MockitoJUnitRunner.class) 
public class EntryServiceTest {

   @Mock private SharedPreferencesHandler sphMock;

   @InjectMocks
   private EntryService entryService;    

    @Test
    public void insertOneEntry() {
        // Arrange
        SparceArray<Entry> sparceArray = new SparseArray<Entry>();
        Mockito.when(sphMock.loadAll()).thenReturn(sparceArray);

        // Act
        entryService.insertEntry(testEntry1, 1);

        // Assert
        assertEquals("Entries in list", 1, sparceArray.size());
        verify(sphMock).insertUpdate(
           Mockito.any(Entry.class, Mockito.any(Integer.class);
    }
}