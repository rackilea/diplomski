List<String> dates = List.of(
    "2019-01-25", 
    "2019-01-25T14:32:23",
    "2019-01-25T14:32:23.12345", 
    "2019-01-25T14:32:23Z", 
    "2019-01-25T14:32:23Z-0500"
);

DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
   "yyyy-MM-dd['T'[HH:mm:ss][.SSSSS]][z][x]"
); // all the possible combinations

dates.forEach( date -> {
            TemporalAccessor accessor = formatter.parseBest(date,                       
       OffsetDateTime::from, // going from most specific date
       LocalDateTime::from, 
       LocalDate::from); // to the less specific 

            System.out.println( accessor.getClass() + " " + accessor);
        }

);

// output for this is 
class java.time.LocalDate 2019-01-25
class java.time.LocalDateTime 2019-01-25T14:32:23
class java.time.LocalDateTime 2019-01-25T14:32:23.123450
class java.time.OffsetDateTime 2019-01-25T14:32:23Z
class java.time.OffsetDateTime 2019-01-25T14:32:23-05:00