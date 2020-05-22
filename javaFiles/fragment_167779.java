@RunWith(MockitoJUnitRunner.class)
public class ChainMethodsMockTest {

    TypedQuery mockedTypedQuery = fluentMock(TypedQuery.class);

    @InjectMocks
    TestService testService;

    @Test
    public void testMockito(){
        final ArrayList value = new ArrayList();
        value.add("a");
        value.add("b");
        Mockito.when(mockedTypedQuery.getResultList()).thenReturn(value);
        final List test = testService.test();
        Assert.assertEquals(2, test.size());
    }

    public static <T> T fluentMock(final Class<T> type) {
        return Mockito.mock(type, Mockito.withSettings().defaultAnswer(
                new ReturnsEmptyValues() {
                    @Override
                    public Object answer(InvocationOnMock invocation) {
                        Object defaultReturnValue = super.answer(invocation);
                        if (type.equals(invocation.getMethod().getReturnType())) {
                            return invocation.getMock();
                        } else {
                            return defaultReturnValue;
                        }
                    }
                }));
    }
}