// Possibly MM.dd.yyyy - we don't know what 12.05.2014 is meant to represent
DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss.SSS");
                                            .withLocale(Locale.US)
                                            .withZoneUTC(); // Adjust accordingly
DateTime dateTime = formatter.parse(text);
long millis = dateTime.getMillis();