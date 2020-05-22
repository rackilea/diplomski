@RunWith(PowerMockRunner.class)
@PrepareForTest(Singleton.class)
public class MySingletonTest {   
    @Test
    public void test() throws Exception{ 
        Whitebox.invokeMethod(Singleton.class, "methodToTest");
    }
}