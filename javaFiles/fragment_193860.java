@Mock
private ProcessHelper processHelper;

@Before
public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    IXMLBatchProcessor iXMLBatchProcessor = (IXMLBatchProcessor) unwrapProxy(xmlProcessor);
    ReflectionTestUtils.setField(iXMLBatchProcessor , "processHelper", processHelper);
}