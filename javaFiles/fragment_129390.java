@RunWith(MockitoJUnitRunner.class)
public class OffStateTest {

    @Mock
    private Fan fan;

    @Test
    public void testChangeState() {
        //Arrange
        OffState offState = new OffState();

        //Act
        offState.changeState(fan);

        //Assert
        Mockito.verify(fan).setState(Mockito.any(OnState.class));
    }
}