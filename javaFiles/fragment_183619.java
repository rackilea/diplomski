@RunWith(SpringJUnit4ClassRunner.class) 
   @ContextConfiguration(locations = { "classpath*:/META-INF/spring/applicationContext.xml"})
   public class SomeTest extends AbstractJUnit4SpringContextTests {

       @Autowired
       MyUser myUser; // use this object for ur crud operations 

       @Test
       public void someTest() throws Exception {                
           MyUser otherObject= myUser.findByUserId(123);
           System.out.println(otherObject.getFirstName());
       }
    }