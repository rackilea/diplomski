@Before
public void setUp() {
   if (!this.getClass().isAnnotatedWith("Version20")) {
      final String version = System.getProperty("my.app.test.version");
      org.junit.Assume.assumeTrue(version.equals("2.0"));
   }
}