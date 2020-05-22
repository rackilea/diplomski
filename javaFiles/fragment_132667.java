@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from "/applicationContext.xml"
// and "/applicationContext-test.xml"
// in the root of the classpath
@ContextConfiguration({"/applicationContext.xml",
                       "/applicationContext-test.xml"})
public class MyTest {
    // class body...
}