DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("'At 'MM/dd/uuuu");
    String dateString = "At 01/08/2018";
    try {
        LocalDate localDate = LocalDate.parse(dateString, dateFormatter);
        System.out.println(localDate);
        // order.setDate(asDate(localDate));
    } catch (DateTimeParseException dtpe) {
        // fails..
    }