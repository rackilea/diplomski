@Before
public void setup() {    
    templateEngine = mock(TemplateEngine.class); //Use a mock

    MockitoAnnotations.initMocks(this);
    emailService.setTemplateEngine(templateEngine);
}