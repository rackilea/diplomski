@RunWith(BurstJUnit4.class)
public class SomeParameterizedTest {

    @Test
    public void someTest(CommunicationStyle style) throws Exception {
        Object configLoader = ...
        Clients = style.clients(configLoader);

        // more logic
    }
}