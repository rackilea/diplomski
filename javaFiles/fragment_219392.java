import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

public class DateTest {

    @org.junit.Test
    public void test() {
        Calendar calendarDate=Calendar.getInstance();
        calendarDate.clear();
        calendarDate.set(2012, 6, 1,0,0,0);
        Assert.assertEquals(0, calendarDate.getTime().compareTo(new Date(2012 - 1900,7-1, 01)));
    }

}