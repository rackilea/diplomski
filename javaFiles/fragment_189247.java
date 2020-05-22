@ContextConfiguration(locations = {
        "classpath:yourconfig.xml"
})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class YourTestClass extends AbstractTestNGSpringContextTests {
 //magic
}