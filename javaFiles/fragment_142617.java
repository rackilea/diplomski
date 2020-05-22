Calendar cal = Calendar.getInstance();

    final int minutes = cal.get(Calendar.MINUTE);
    cal.set (Calendar.MINUTE, minutes - (minutes % 15));
    cal.set (Calendar.SECOND, 0);
    cal.set (Calendar.MILLISECOND, 0);

    System.out.println (new Date(cal.getTimeInMillis()));