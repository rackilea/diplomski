DateTimeFormatter dfs = new DateTimeFormatterBuilder()
                           .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd"))                                                                 
                           .appendOptional(DateTimeFormatter.ofPattern("dd.MM.yyyy"))                                                                                     
                           .toFormatter();
LocalDate d = LocalDate.parse("2014-05-14", dfs); //2014-05-14
LocalDate d2 = LocalDate.parse("14.05.2014", dfs); //2014-05-14