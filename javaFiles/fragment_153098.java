@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class MainActionTest
{
    @Inject MainAction mainAction;

    @Test
    public void testThatLoggerIsCalled(@Mocked final Logger logger)
    {
        mainAction.doTheAction();

        new Verifications() {{ logger.log(anyString); }};
    }
}