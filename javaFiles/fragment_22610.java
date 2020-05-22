@RunWith(MockitoJUnitRunner.class)
public class LoadControllerTest {

    @Mock
    private LoadController.FileSorter fileSorter;
    @Mock
    private VBox mainVBox;
    @InjectMocks
    private LoadController loadController;

    @Test
    public void testTestOnly(){
        loadController.testOnly();
    }
}