long time = System.currentTimeMillis();
Instant instant = Instant.ofEpochMilli(time);
ZoneId.getAvailableZoneIds().stream().forEach(id -> {
        ZoneId zId = ZoneId.of(id);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zId);
        System.out.printf(
            "The current time in %s is %s%n",  
            zId, localDateTime.format(DateTimeFormatter.ISO_DATE_TIME)
        );
    }
);