@RunWith(PowerMockRunner.class)
@PrepareForTest({LoggerFactory.class})
public class MyTest {

    @Test
    public void test1() {
        //Arrange
        Logger logger = PowerMockito.mock(Logger.class);

        PowerMockito.mockStatic(LoggerFactory.class);           
        PowerMockito.when(LoggerFactory.getLogger(Example.class)).thenReturn(logger);

        Example example = new Example();

        //Act
        example.foo(..);

        //Assert
        Mockito.verify(logger).warn("Warning");
    }
}