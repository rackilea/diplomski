package Q45436872;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestsInit 
{

    protected String value;

    @BeforeClass
    public void testInit(){
    System.out.println("Entered testInit in TestsInit class,to set the value.");
    value="Something";
    }

    @Test
    public void SomeTest(){
    boolean isTrue=true;
    System.out.println("Entered SomeTest in TestsInit class.");
    Assert.assertTrue(isTrue);
    }
}