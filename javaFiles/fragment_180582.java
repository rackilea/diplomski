DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String attDate = "2016-08-30T06:18:17.123-0600";
        //attDate = attDate.substring(0, 19);
        System.out.println("####attask date: "+attDate);
        LocalDateTime dt = LocalDateTime.parse(attDate, formatter);
        System.out.println(dt);