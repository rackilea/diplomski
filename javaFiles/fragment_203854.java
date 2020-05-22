Calendar c = Calendar.getInstance();
    c.set(Calendar.MONTH, Calendar.MAY); // may is just an example
    c.set(Calendar.YEAR, 2012);
    int th = 0;
    int maxDayInMonth = c.getMaximum(Calendar.MONTH);
    for (int d = 1;  d <= maxDayInMonth;  d++) {
        c.set(Calendar.DAY_OF_MONTH, d);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if (Calendar.THURSDAY == dayOfWeek) {
            th++;
        }
    }