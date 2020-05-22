// Create an instant object from the timestamp
        Instant instant = Instant.ofEpochMilli(3600);
        instant.atZone(ZoneOffset.UTC);

        //Add X number of days to instant
        instant.plus(1, ChronoUnit.DAYS);


        // Create a date formatter
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        // Create the date from instant & format it from date formatter
        Date date = Date.from(instant);
        String formattedDate = formatter.format(date);
        System.out.println(formattedDate);