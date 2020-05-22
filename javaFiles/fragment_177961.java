Date start = GregorianCalendar.getInstance().getTime();
        Thread.sleep(100);
        Date end = GregorianCalendar.getInstance().getTime();

        long longVal = end.getTime() - start.getTime();

        long hours = longVal / 3600000;
        long mins = (longVal % 3600) / 60000;
        long secs = longVal % 60000;

        System.out.println(hours + " " + mins + " " + secs);