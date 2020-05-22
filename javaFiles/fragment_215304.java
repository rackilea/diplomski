System.out.println(HijrahDate.of(1436, 2, 30)); // Hijrah-umalqura AH 1436-02-30

DateTimeFormatter fh =
    DateTimeFormatter.ofPattern(
        "dd-MM-yyyy",
        Locale.forLanguageTag("en")
    ).withChronology(HijrahChronology.INSTANCE);
System.out.println(HijrahDate.from(fh.parse(input))); 
// Hijrah-umalqura AH 1436-02-30
System.out.println(LocalDate.from(HijrahDate.from(fh.parse(input)))); 
// 2014-12-22