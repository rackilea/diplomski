@RunWith(value = Parameterized.class)
public class DateTest {

    private DateV1 date;

    public DateTest(DateV1 date) {
        this.date = date;
    }

    @Parameters
    public static Collection<Object[]> data() {
        final Date currDate = new Date();
        Object[][] data = new Object[][] { { new DateV1(currDate) }, { new DateV2(currDate) } };
        return Arrays.asList(data);
    }

    @Test
    public void getYearShouldReturn2013() {
        Assert.assertEquals(2013, date.getYear());
    }
}