@RunWith(PowerMockRunner.class)
@PrepareForTest({SettingsView.class})
public class PowermockFinalClassTest {

    private SettingsView view;

    @Test
    public void testMockingStatic() {
        view = PowerMockito.mock(SettingsView.class);

        String expected = "mocked call";
        Mockito.when(view.getSomething()).thenReturn(expected);

        Assert.assertEquals(expected, view.getSomething());
    }
}