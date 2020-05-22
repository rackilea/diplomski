@RunWith(MockitoJUnitRunner.class)
public class TestServiceTest {

    public static final String MYKEY = "Mykey";
    @Spy
    TestService testService;

    @Test
    public void testCache() throws ExecutionException {
        doReturn(MYKEY).when(testService).getKey(MYKEY);

        String result=testService.getkeyFromCache(MYKEY);
        String result2nd=testService.getkeyFromCache(MYKEY);

        verify(testService).getKey(MYKEY);
    }

}