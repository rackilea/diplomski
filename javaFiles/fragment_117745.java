Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.set(Calendar.HOUR_OF_DAY,0);
    calendar.set(Calendar.MINUTE,0);
    calendar.set(Calendar.SECOND,5);
    calendar.set(Calendar.MILLISECOND,0);

    System.out.println(formatter.format(calendar.getTime()));

    Calendar another = Calendar.getInstance();
    another.setTime(calendar.getTime());
    another.set(Calendar.HOUR_OF_DAY,0);
    another.set(Calendar.MINUTE,0);
    another.set(Calendar.SECOND,calendar.get(Calendar.SECOND)+5);
    another.set(Calendar.MILLISECOND,0);

    System.out.println(formatter.format(another.getTime()));