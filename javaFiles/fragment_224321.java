import org.testng.Assert;
import org.testng.annotations.Test;

public class Q45191867_Assert_Pass_Suite 
{

    @Test   
    public void TC002_CheckAssert() 
    {
        System.out.println("ajkcbh");
        try
        {
            Assert.assertEquals("Pass", "Pass");
        }
        catch(Exception e)
        {
            System.out.println("Exception:"+e.getLocalizedMessage());
        }
    }
}