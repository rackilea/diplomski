import org.junit.Assert;
import org.junit.Test;


public class RegisterTest {

    @Test
    public void testRegisterToString() {

        Register source = new Register( new boolean[] {true, true, false, false, true, false, true, false } );

        String result = "11001010";

        Assert.assertEquals( result, source.toString() );

    }

    @Test
    public void testRegisterCloning() {

        Register source = new Register( new boolean[] {true, true, false, false, true, false, false, false } );
        Register clone = source.clone();

        Assert.assertEquals( source.toString(), clone.toString() );

    }

}