public class DemoClass{

@Test(skipFailedInvocations=true, retryAnalyzer=RetryAnalyzer.class)
public void test(){
    Assert.assertTrue(false);
}