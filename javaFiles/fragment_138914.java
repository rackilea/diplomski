public class SpyTest {
    @Spy
    private MyTestClass myTestClass;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void spyInsteadOfPowermock() {
        when(myTestClass.getObject()).thenReturn(Integer.valueOf(3));

        assertThat(myTestClass.doSomethingMethod()).isEqualTo("3");
    }

    class MyTestClass{
        public String doSomethingMethod(){
            return getObject().toString();
        }

        Object getObject() {
            return new Object();
        }
    }
}