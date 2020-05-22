@RunWith(SomeTestRunner.class)
@Ignore("Not a real test class because it does not contain any @Test methods, but needed to keep surefire happy")
public class ParentTest {
    // this is the reusable class that is in the jar file
}


public class SomeIntegrationTest extends ParentTest {

    @Test
    public void simpleTest() {
       // given, when, then
    }
}