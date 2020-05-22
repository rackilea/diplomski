DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
ZoneId zone = ZoneId.of("Asia/Kolkata");
ZonedDateTime fromDate = LocalDate
    // parse "from" string
    .parse(from, fmt)
    // start of day at Kolkata timezone
    .atStartOfDay(zone);
ZonedDateTime toDate = LocalDate
    // parse "to" string
    .parse(to, fmt)
    // get start of next day
    .plusDays(1).atStartOfDay(zone);

// convert the Date to ZonedDateTime
for (Order order : orders) {
    ZonedDateTime orderDate = order.getOrderDate().toInstant().atZone(zone);
    if ((orderDate.isAfter(fromDate) || orderDate.isEqual(fromDate)) && (orderDate.isBefore(toDate))) {
        ...
    }
}