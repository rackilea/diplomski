@RunWith(PowerMockRunner.class)
@PrepareForTest(LegacyPropertyManager.class)
public class YourClass {

  @Before public void stubLegacyPropertyManager() {
    Mockito.when(LegacyPropertyManager.getProp("legacy.property.key"))
        .thenReturn("42");
  }

  @Test public void yourTest() {
    // ...
  }
}