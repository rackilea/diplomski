public class DockerTest {
    GenericContainer<?>container  = new GenericContainer<>("ibmcom/informix-developer-database:latest")
        .withExposedPorts(9088, 9089, 27017, 27018, 27883).withEnv("LICENSE", "accept");
@Test
public void testIfxContainer() throws Exception {
    container.start();
    System.out.println("Informix started");
    //test the connection
    try(Connection c = DriverManager.getConnection("jdbc:informix-sqli:localhost:"  + container.getFirstMappedPort() + "/sysmaster:user=informix;password=your-password")) {
      try(Statement s = c.createStatement(); ResultSet rs = s.executeQuery("SELECT FIRST 10 tabname from systables");) {
        while(rs.next()) {
          System.out.println(r.getString(1));
        }
      }
    }
  }
}