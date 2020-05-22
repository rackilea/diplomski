DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                                        .appendPattern("yyyy")
                                        .appendLiteral('-')
                                        .appendValue(MONTH_OF_YEAR)
                                        .appendLiteral('-')
                                        .appendValue(DAY_OF_MONTH)
                                        .parseDefaulting(HOUR_OF_DAY, HOUR_OF_DAY.range().getMinimum())
                                        .parseDefaulting(MINUTE_OF_HOUR, MINUTE_OF_HOUR.range().getMinimum())
                                        .parseDefaulting(SECOND_OF_MINUTE, SECOND_OF_MINUTE.range().getMinimum())
                                        .parseDefaulting(NANO_OF_SECOND, NANO_OF_SECOND.range().getMinimum())
                                        .toFormatter();
System.out.println(LocalDateTime.parse("2015-9-5", formatter));
System.out.println(LocalDateTime.parse("2015-10-01", formatter));