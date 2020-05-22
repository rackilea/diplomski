@RunWith(Suite.class)
@SuiteClasses({ Test1.class, Test2.class })
public class AllTests {
   @ClassRule
   public static EmbeddedTomcatServer tomcat = new EmbeddedTomcatServer();

}