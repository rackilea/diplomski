@RunWith(MockitoJUnitRunner.class)
public class ServiceLogicTest {
    @Mock ServiceDAO serviceDAO;
    @InjectMocks ServiceLogic serviceLogic;

    @Test
    public void ensure_executeStatement_is_called_with_right_param() throws Exception {
        // given
        String input = "Some input";

        // when
        serviceLogic.getDataFrom(input);

        // then
        verify(serviceDAO).executeStatement("expected param");
    }
}