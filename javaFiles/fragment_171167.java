@ExtendWith(MockitoExtension.class)
public class HealthStatusImplTest{

    private HealthStatusImpl healthStatusImpl;

    @Mock
    private RestTemplateService restTemplateServiceMock;

    @BeforeEach
    public void beforeEach(){
        healthStatusImpl = new HealthStatusImpl(restTemplateService);
    }

    @Test
    public void healthCheck_when_200_is_returned(){
       Mockito.when(restTemplateServiceMock)
              .getForHealthCheck().thenReturn(new ResponseEntity(HttpStatus.OK));
       assertEquals(200, healthStatusImpl.healthCheck());
    }

    @Test
    public void healthCheck_when_200_is_not_returned(){
       Mockito.when(restTemplateServiceMock)
              .getForHealthCheck().thenReturn(new ResponseEntity(HttpStatus.NOT_FOUND));
       assertEquals(400, healthStatusImpl.healthCheck());
    }

}