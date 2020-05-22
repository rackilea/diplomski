Calendar cal = Calendar.getInstance();
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        cal.setTimeZone(timeZone);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(timeZone);
        String gmtDateStr = sdf.format(cal.getTime());
        System.out.println("Formatted GMT time = " + gmtDateStr);

        // To CST
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TimeZone cst = TimeZone.getTimeZone("CST");
        sdf2.setTimeZone(cst);

        System.out.println("FORMATTED CST DATE = " + sdf2.format(cal.getTime()));