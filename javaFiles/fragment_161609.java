@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-context.xml" })
public class ServiceIT{
@Autowired
private ServiceA serviceA;

@MockBean
private EmailUtil emailUtil;

@Test
public void testA(){
// prepare data mock in H2 DB

//given(this.emailUtil.sendEmail(ArgumentMatchers.any()).willReturn( custom object);
serviceA.invoke(arg1, arg2);
// assertions
     }
 }