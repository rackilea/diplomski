@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { xxx.MainConfig.class })
@ActiveProfiles({ "database-test", "classpath" })
public class DynVdynOperationsImplTest {

   @Autowired
   ApplicationContext context;

   @Test
   public void testSend() {
   underTest = context.getBean(DynVdynOperations.class);
   underTest.sendVdyn("0254", null, null);
   ... }