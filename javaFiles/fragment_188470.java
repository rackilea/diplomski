public class StringResourceUtilTest {


    private StringResourceUtil mResourceUtil;

    @Mock
    private Context mContext;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mResourceUtil = new StringResourceUtil(mContext);
        // setup mock return type
        // mock objects are not real,so need to moeck the behavior of method as well
        when(mContext.getString(R.string.a123)).thenReturn("123");
    }


    @Test
    public void getString() {
        int resId = R.string.a123;
        // check the return type
        assertEquals("123",mResourceUtil.getString(resId));
    }
}