IDManager  test = new IDManager();
Timestamp output = test.convertStringToTimestamp("07.10.2018 08:45:00");

final Timestamp timestamp =
        Timestamp.valueOf(LocalDateTime.of(LocalDate.of(2018, 10, 7), LocalTime.of(8, 45, 0)));
Assert.assertEquals("TimeStamps should match!", timestamp, output);