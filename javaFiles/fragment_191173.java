@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@TestPropertySource("classpath:config/mailing.properties")
public class DemoApplicationTests {

    @Autowired
    MailService mailService;

    @Test
    public void contextLoads() {
        String s = mailService.getMailFrom();
        System.out.println(s);
    }
}