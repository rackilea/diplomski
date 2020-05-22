public class SomeJunitTest {

  @Rule
  public TogglzRule togglzRule = TogglzRule.allEnabled(MyFeatures.class);

  @Test
  public void testToggleFeature() {

    // all features are active by default  
    assertTrue(MyFeatures.FEATURE_ONE.isActive());

    // you can easily modify the feature state using the TogglzRule
    togglzRule.disable(MyFeatures.FEATURE_ONE);
    assertFalse(MyFeatures.FEATURE_ONE.isActive());

  }

}