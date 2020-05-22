long test_timestamp = 1499070300L;
LocalDateTime triggerTime =
       LocalDateTime.ofInstant(Instant.ofEpochSecond(test_timestamp),
                               TimeZone.getDefault().toZoneId());   

System.out.println(triggerTime);