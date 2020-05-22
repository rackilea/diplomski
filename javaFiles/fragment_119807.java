@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringApplication.class) // your main class normally with @SpringBootApplication annotation
public class DriverServiceTests{
    @Autowired
    protected DriverService driverService;

    @Test
    public void testFindAll() throws Exception {

        System.out.println(driverService.findAll());
    }

}