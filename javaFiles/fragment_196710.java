public class TestHomePage {
    private static WicketTester tester;

    @BeforeClass
    public static void setUp() {
        tester = new WicketTester(new WicketApplication() {
            @Override
            protected void init() {
                //Override init to use SpringUtil's SpringContext due to missing WebApplicationContext
                addComponentInstantiationListener(new SpringComponentInjector(this, SpringUtil.getContext()));
            }
        });
    }

    @Test
    public void testRenderMyPage() {
        //start and render the test page
        tester.startPage(HomePage.class);

        //assert rendered page class
        tester.assertRenderedPage(HomePage.class);

        //assert page contents
        tester.assertContains("Welcome to my webpage");
    }
}