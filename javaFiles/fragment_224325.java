import static commentStrip.CommentStripper.strip;
import static org.junit.Assert.*;

import org.junit.Test;

public class CommentStripperTest {

    @Test
    public void test() {
        assertEquals("\"test\"", strip("\"test\"//hello\"test\""));
        assertEquals("\"test\"\"test\"", strip("\"test\"/*hello*/\"test\""));
        assertEquals("test"+System.lineSeparator()+"test", strip("test//linecomment"+System.lineSeparator()+"test"));
        assertEquals("test", strip("test/*test"));
        assertEquals("\"test//hellotest\"", strip("\"test//hellotest\""));
        assertEquals("\"test/*hello*/test\"", strip("\"test/*hello*/test\""));
    }

}