String date1 = "2018-01-03T12:17:35.000+0200";
String date2 = "2018-01-10T14:10:03.000+0200";
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSx");
long days = ChronoUnit.DAYS.between(
                    OffsetDateTime.parse(date1, fmt),
                    OffsetDateTime.parse(date2, fmt));