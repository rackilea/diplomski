package Q45436872;

import org.testng.annotations.Test;

public class TestsOther  extends TestsInit
{

    @Test (dependsOnMethods = {"SomeTest"})
    public void OtherTest(){
    System.out.println("Entered OtherTest test in TestsOther class with value: "+value);
    }
}