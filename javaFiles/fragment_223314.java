Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.MILLISECOND, 0);      
    calendar.set(Calendar.SECOND, 37540);
    System.out.println(new SimpleDateFormat("HH:mm:ss").format(calendar.getTime()));