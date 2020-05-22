@RunWith(MockitoJUnitRunner.class)
public class GeneralConfigServiceImplTest  {

    @InjectMocks
    private GeneralConfigService generalConfigService;

    @Mock
    private GeneralConfigDAO generalConfigDAO;

    @Test
    public void testAddGeneralConfigCallDAOSuccess() {
       // generalConfigService is already instantiated and populated with dependencies here
       ...
    }
}