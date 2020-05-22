@Spy
private Logger logger = LoggerFactory.getLogger(MyController.class);

@InjectMocks
private MyController controller;

@Before
public void prepare() {
    MockitoAnnotations.initMocks(this);
}