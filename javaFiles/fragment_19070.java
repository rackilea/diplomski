String[] formats = {
            "yyyy-MM-dd HH:mm:ss",
            "yy-MM-dd HH:mm:ss:SSS"
    };

    String tryparseString = "18-01-22 00:03:34:071";

    for (String format : formats) {
        try {
            LocalDateTime.parse(tryparseString, DateTimeFormatter.ofPattern(format));
            System.out.println("Yeah! We found a CAN PARSE date format = " + format);
        } catch (DateTimeParseException dtpe) {
            System.out.println(dtpe);
        }
    }