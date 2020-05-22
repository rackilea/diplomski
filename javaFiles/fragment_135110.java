List<Date> dates = new ArrayList<>();
dates.add(java.sql.Date.valueOf(LocalDate.of(2016, 11, 12)));
dates.add(java.sql.Date.valueOf(LocalDate.of(2016, 12, 15)));
dates.add(java.sql.Date.valueOf(LocalDate.of(2016, 11, 13)));

boolean hasConsecutiveDates
    = dates.stream()
           .sorted()
           .anyMatch(new Predicate<java.sql.Date>() {
             private java.sql.Date previous;

             @Override
             public boolean test(java.sql.Date date) {
               boolean consecutiveByDay = false;
               if (previous != null) {
                 consecutiveByDay =
                     ChronoUnit.DAYS.between(previous.toLocalDate(), date.toLocalDate()) == 1;
               }

               previous = date;
               return consecutiveByDay;
             }
           });