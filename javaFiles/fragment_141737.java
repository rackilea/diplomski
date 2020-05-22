@Mock
private WorkJobRepository workJobRepository;

@InjectMocks
private ReadWorkJob readWorkJob;

@Before
public void setUp() throws Exception {
    when(workJobRepository.findById(any())).thenReturn(null);
    logger.info("check point test case setup");
}