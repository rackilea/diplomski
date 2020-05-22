long test_timestamp = 1499070300000L;
LocalDateTime triggerTime =
        LocalDateTime.ofInstant(Instant.ofEpochMilli(test_timestamp), 
                                TimeZone.getDefault().toZoneId());  

System.out.println(triggerTime);