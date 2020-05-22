import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.Test;

public class DateExpressionUtilsTest {

    @Test
    public void test_parse() {
        assertEquals(
                FastDateFormat.getInstance("yyyy-MM-dd hh:mm").format(
                        new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000)),
                FastDateFormat.getInstance("yyyy-MM-dd hh:mm").format(DateExpressionUtils.eval("now + 1.week")));

        try {
            DateExpressionUtils.eval("now + 1.week; Thread.sleep(1000);");
            fail();
        } catch (SecurityException e) {
            // ok
        }
    }
}