DateTimeFormatter dateFormatter = DateTimeFormatter
            .ofPattern("E, yyyy-MM-dd", Locale.ENGLISH);
    Date oldfashionedDate = DateDP.getDate();
    ZonedDateTime dateTime = oldfashionedDate.toInstant().atZone(ZoneId.systemDefault());
    String dateString = dateTime.format(dateFormatter);
    System.out.println(dateString);