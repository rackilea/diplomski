@Configuration
    @PropertySource(value={
  "classpath:usermgmt.properties",
  "classpath:ldap.properties",
  
     })
     @ContextConfiguration(locations = {
  "file:src/main/webapp/WEB-INF/spring-config.xml",
  "file:src/main/webapp/WEB-INF/conf/applicationContext-email.xml",
  "file:src/main/webapp/WEB-INF/conf/applicationContext-jdbc.xml"
  
   })
   @WebAppConfiguration
   @RunWith(SpringJUnit4ClassRunner.class)
   public class ClassTest {

   }