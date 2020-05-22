/** Tests for {@link MyApplication}. */
@RunWith(JUnit4.class)
public final class MyApplicationTest {
  // Note that we don't need to construct a full MyConfiguration object here
  // since we're providing our own binding, not using MyConfigurationModule.
  // Instead, we just bind the pieces that we need for this test.
  @Bind @Config("x") String xConfig = "x-configuration-for-test";

  @Before public void setUp() {
    // See https://github.com/google/guice/wiki/BoundFields
    Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
  }

  @Inject MyApplication app;

  @Test public void testMyApp() {
    // test app here
  }
}