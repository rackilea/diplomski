@RunWith(MockitoJUinitRunner.class)
public class PluginTest {
    @Mock DistributionManager mockedManager;
    @InjectMocks Plugin testedPlugin = new Plugin(); // initialization not need when using Mockito 1.9.x

    @Test public void plugin_should_call_the_the_manager_on_doSomething() {
        // given
        // when
        // then
    }

    // other scenarios
}