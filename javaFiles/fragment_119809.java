public class DriverServiceTest extends ParentTest{
    @Autowired
    protected DriverService driverService;

    @Test
    public void testFindAll() throws Exception {
        System.out.println(driverService.findAll());
    }

    // test with security
    @Test
    @WithMockUser(username = "Mikasa", roles = {"captain"})
    public void kill_withCaptain_titanKilled(){
        // test if users with role "captain" can kill the titan
        // there are certain requirements for your security config in order to use @WithMockUser, please take a look at spring doc for more details.
    }
}