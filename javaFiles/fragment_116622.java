long day = System.currentTimeMillis();
        Calendar cal = Calendar.getInstance();
        java.text.SimpleDateFormat month = new java.text.SimpleDateFormat("yyyy-MMM-dd HH:mm:ss:S"); // not sure how to assign this value inside
        cal.setTimeInMillis(day);
        cal.set(Calendar.HOUR_OF_DAY, 00);
        cal.set(Calendar.MINUTE, 00);
        cal.set(Calendar.SECOND, 00);
        cal.set(Calendar.MILLISECOND, 000);
        Date todayDate = cal.getTime();

        Timestamp current = new Timestamp(todayDate.getTime());
        System.out.println(month.format(current));