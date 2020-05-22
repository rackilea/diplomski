@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "/applicationContextTest.xml" })

public class ApacheCommonCfg2Spring extends AbstractJUnit4SpringContextTests {

    private TestConfiguration tcfg;

    @Test
    public void configuration(){
        tcfg  = this.applicationContext.getBean("testConfig", TestConfiguration.class);
        System.out.println(tcfg.getDomain());
    }

}