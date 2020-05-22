@RunWith(PowerMockRunner.class)
@PrepareForTest({Service.Factory.class})
public class AImplTest {

    private Service serviceMock;

    @Before
    public void setUp() {
        PowerMockito.mockStatic(Service.Factory.class);
        serviceMock = Mockito.mock(Service.class);
        PowerMockito.when(Service.Factory.getInstance()).thenReturn(serviceMock);
    }

    @Test
    public void generateTest() throws Exception {
        Mockito.doReturn("mockid").when(serviceMock).generate(Mockito.anyString());
        Assert.assertEquals("mockid", new AImpl().method1("aaa"));
    }
}