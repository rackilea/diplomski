@ContextConfiguration("classpath:services.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RunnableServiceTest {

   @Autowired
   private List<Service> lAllService;

   @Test
   public void testConfiguration(){
       assertFalse(lAllService.isEmpty());
   }
}