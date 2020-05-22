@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {AppApplication.class,TestConfiguration.class})
@WebAppConfiguration
public class SampleServiceImplTest {

    @Configuration
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    protected static class TestConfiguration {
         @Bean
         @Primary
         public SampleDaoImpl gatSampleDaoImpl(){
               return Mockito.mock(SampleDaoImpl.class);
         }
    }

    @Autowired
    private SampleDaoImpl dao;

    @Autowired
    private SampleService svc;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this); 
    }   


    @Test(expected=AccessDeniedException.class)
    @WithMockUser(username="usr",roles={"ROOT"})
    public void doItDeniedTest() {
        svc.doIt();
    }

    @Test
    @WithMockUser(username="usr",roles={"USR"})
    public void doItTest() {

    Boolean ctrl = Boolean.FALSE;
    Mockito.when(dao.getValue()).thenReturn(ctrl);

    Boolean rt = svc.doIt();
    assertEquals(ctrl,rt);      
    }

}