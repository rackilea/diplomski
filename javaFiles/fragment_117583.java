public final class MyComparator
    implements Comparator<String>
{
    // Date parsing
    // Note: SimpleDateFormat is not thread-safe, if possible use Joda Time instead
    private static final DateFormat fmt = new SimpleDateFormat("dd/MM/YYYY");

    private static final Comparator<String> INSTANCE = new MyComparator();

    private MyComparator()
    {
    }

    public static Comparator<String> getInstance()
    {
        return INSTANCE;
    }

    @Override
    public int compare(String o1, String o2)
    {
        // Grab dates
        String s1 = o1.subString(0, 10);
        Date d1 = fmt.parse(s1);
        String s2 = o2.subString(0, 10);
        Date d2 = fmt.parse(s2);

        // Date implements Comparable<Date>, so we can use that...
        int ret = d1.compareTo(d2);

        // If dates are equal, compare the rest of the strings instead.
        return ret != 0 ? ret : o1.subString(10).compareTo(o2.subString(10));
    }
}