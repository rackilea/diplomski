@Groups({ "myGroup1", "myGroup2"})
public class MyTestCase {
    @Test
    @Groups("aMethodLevelGroup")
    public void myTest() {
    }
}