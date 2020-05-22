@RunWith(MockitoJUnitRunner.class)    
public class FileServiceTest {

    @Test(expected = RuntimeException.class)
    public void myMethodToTest() throws Exception {         
        File file = Mockito.mock(File.class);
        Mockito.when(file.delete()).thenReturn(false);          
        FileService.delete(file, "test");
    }
}