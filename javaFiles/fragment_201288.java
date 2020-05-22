public class Test1 {

   @ClassRule
   public static EmbeddedTomcatServer tomcat = new EmbeddedTomcatServer();

   //tests as normal, no more @BeforeClass or @AfterClass

}

public class Test2 {

   @ClassRule
   public static EmbeddedTomcatServer tomcat = new EmbeddedTomcatServer();

   //tests as normal, no more @BeforeClass or @AfterClass

}