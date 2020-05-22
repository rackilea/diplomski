@RunWith(SpringRunner.class)
@SpringBootTest
public class MultifamilyIntegrationTest {

    @Autowired
    protected TestService testService;

    @Test
    public void test() {
        testService.getUsers();
    }

}