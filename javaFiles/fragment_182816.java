@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestContextConfiguration.class)
public class ReportResponseAssemblerTest {

    @Autowired
    ReportInstanceResponseAssembler reportResponseAssembler;

    @Test
    public void testPlaceHolder() {
        Assert.assertNotNull(reportResponseAssembler);
    }
}

@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.blahpackage.service.assembler" })
@Configuration
public class TestContextConfiguration {

}