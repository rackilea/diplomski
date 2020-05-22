DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:ss:SSS a X")
        .withLocale(Locale.ENGLISH).withZone(ZoneId.of("Asia/Kolkata"));
ZonedDateTime first = ZonedDateTime.parse("16-Feb-2012 12:03:45:999 AM +0530", formatter);
ZonedDateTime second = ZonedDateTime.parse("16-Feb-2012 12:03:55:999 AM +0530", formatter);
Comparator<ZonedDateTime> comparator = Comparator.comparing(
        zdt -> zdt.truncatedTo(ChronoUnit.MINUTES));
System.out.println(comparator.compare(first, second));