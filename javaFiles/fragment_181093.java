package com.myapp.test;

@ContextConfiguration(locations = { "/META-INF/spring/applicationContext.xml","/META-INF/spring/applicationContext-security.xml" })
public class TestMyService extends AbstractJUnit4SpringContextTests {

    @Autowired
    MyService service = new MyService();

    private void setUp() {
        //Do the setting up of your classes for the test
    }

    @Test
    public void testOperation() throws IOException {
        //My Test Code here
    }
}