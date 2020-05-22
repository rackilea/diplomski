import static org.junit.Assert.assertTrue;

import java.io.StringWriter;

import org.junit.Test;

public class XYZ
{

    @Test
    public void test()
    {

        StringWriter result = new StringWriter();
        result.append("<3>textValue</3>");
        String expected = "<3>textValue</3>";
        assertTrue("Should have contained the required result", result.toString().contains(expected));
    }

}