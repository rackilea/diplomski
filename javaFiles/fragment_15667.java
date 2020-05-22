@BaseSpringTest
public abstract class AbstractBaseTests extends AbstractTestNGSpringContextTests {
    // ...
}

@ContextConfiguration(locations = {"/web/WEB-INF/spring-extension.xml" }, name = "parent")
public class MyTest extends AbstractBaseTests {
    // ...
}