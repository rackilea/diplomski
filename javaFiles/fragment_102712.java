public class IntegratorClassTest{
    @InjectMocks
    IntegratorClass integratorClass;

    @Mock
    Validator validator;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getCmsOffersTest()throws Exception{
        //Arrange
        ContentService contentService = Mockito.mock(ContentService.class);
        RequestClass requestClass = Mockito.mock(RequestClass.class);
        ContentList contentResponse = getContentList();
        Mockito.when(contentService.getContentCollection()).thenReturn(contentResponse);

        Mockito.doNothing().when(validator).validateData(any(List<OfferDetails>.class));

        //Act
        List<OfferDetails> offerListResult = integratorClass.getCmsOffers(contentService, requestClass);

        //Assert
        assertTrue(offerListResult.size() > 0);
    }
}