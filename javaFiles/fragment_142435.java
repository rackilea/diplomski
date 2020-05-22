import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PayrollTesCase {

    @Test
    public void testCalculate() {
        Message m = new Message(new Thing("a", "b", "c", "d", "e"));
        assertEquals("abcde", m.toString());
    }

}