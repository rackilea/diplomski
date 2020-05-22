@ContextConfiguration(classes = {MyTestingConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TSUserBeanTest {
  @Autowired
  private MyService myService;

  //testing here
}