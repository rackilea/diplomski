@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest
class TestClass{

    @Autowired
    ApplicationContext ctx;

    @Test
    public void testRunMethod() {
        CommandLineRunner runner = ctx.getBean(CommandLineRunner.class);
        runner.run();
    }

}