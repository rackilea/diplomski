String mytime ="2011-12-03 12:00:19";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
        Date myDate = dateFormat.parse(mytime);
        System.out.println("=== > " + myDate);
        SimpleDateFormat timeFormat = new SimpleDateFormat("EEE d MMMMM yyyy");
        String time = timeFormat.format(myDate);
        System.out.println("=== > " + time);