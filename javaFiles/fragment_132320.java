public class SomeTest {
    @Rule
    public MyTestRule myRule = new MyTestRule("myConfigFile.ini");
    ...
}

public class MyTestRule extends ExternalResource {
    ...
    protected void before() { ... }
    ...
}