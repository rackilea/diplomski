String s = LocalDateTime.now().toString(); // ISO standard representation

// LocalDateTime to old Date:
Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

// Old Date holding time to LocalDateTime:
LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(),
        ZoneId.systemDefault());