private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

public static void main(String[] args) {
    final TreeMap<Date, Integer> map = new TreeMap<Date, Integer>() {
        @Override
        public Integer put(Date key, Integer value) {
            if (key != null) {
                return super.put(key, value);                  
            }
            return null;
        }
    };
    map.put(parseDate("2013-01-23"), 10);
    map.put(parseDate("2013-03-24"), 0);
    map.put(parseDate("2012-12-20"), 3);
    for (final Entry<Date, Integer> entry : map.descendingMap().entrySet()) {
        if (entry.getValue() > 0) {
            System.out.println(entry + " has nonzero value");
            break;
        }
        System.out.println(entry + " has zero value. Continue looking.");
    }
}

public static Date parseDate(final String date) {
    if (date == null) {
        return null;
    }
    try {
        return dateFormat.parse(date);
    } catch (ParseException ex) {
        ex.printStackTrace(System.out);
        return null;
    }
}