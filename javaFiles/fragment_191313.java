@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private JobConfig jobConfig;

    @Test
    void contextLoads(){
        System.out.println(jobConfig);
    }

}