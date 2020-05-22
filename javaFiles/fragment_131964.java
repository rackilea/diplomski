String date = "2018-01-09T11:11:02.0+03:00";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    DateTimeFormatter formatterOut = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm");
    LocalDate parsedDate = LocalDate.parse(date, formatter);

    String formattedDate = formatterOut.format(parsedDate);
    Log.d("Date format", "output date :" + formattedDate);