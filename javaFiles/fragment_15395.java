SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();
    cal.setTime(fmt.parse("2014-03-29"));
    long start = cal.getTimeInMillis();
    start += cal.getTimeZone().getOffset(start);
    cal.setTime(fmt.parse("2014-03-31"));
    long end = cal.getTimeInMillis();
    end += cal.getTimeZone().getOffset(end);

    System.out.println((end - start)/86400000.0);