@RunWith(PowerMockRunner.class)
@PrepareForTest(DepedencyService.class)
public class ComponentTest {
    @Test
    public void testComponentMethod() {
        //Arrange        
        int expected = 1;
        PowerMockito.mockStatic(DepedencyService.class);
        Mockito.when(DepedencyService.getImportantValue()).thenReturn(expected);
        Component subject = new Component();

        //Act
        int actual = subject.componentMethod();

        //Assert
        assertEquals(expected, actual);
    }
}