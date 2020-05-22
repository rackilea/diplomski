public class DateComparator implements Comparator<Date> {

    private boolean reverse;

    public DateComparator(boolean reverse) {
        this.reverse = reverse;
    }

    public int compare(Date o1, Date o2) {
        if (o1 == null || o2 == null) {
            return o2 != null ? (reverse ? 1 : -1) : (o1 != null ? (reverse ? -1 : 1) : 0);
        }
        int result = o1.compareTo(o2);
        return reverse ? result * -1 : result;
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date[] dates = new Date[]{null, dateFormat.parse("10-10-2013"), null, dateFormat.parse("10-10-2012"), dateFormat.parse("10-10-2015"), dateFormat.parse("10-10-2011"), null};
        List<Date> list = Arrays.asList(dates);
        Collections.sort(list, new DateComparator(false));
        System.out.println(list);
        Collections.sort(list, new DateComparator(true));
        System.out.println(list);
    }
}