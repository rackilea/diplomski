String ep ="a1527069600";
    long epoch = Long.parseLong(ep.substring(1));
    Instant inst = Instant.ofEpochSecond(epoch);
    LocalDateTime ldt = inst.atZone(ZoneId.of("Asia/Calcutta")).toLocalDateTime();

    System.out.println(ldt);

    PreparedStatement ps = myDatabaseConnection.prepareStatement(
            "insert into my_table (my_date_time) values (?)");
    ps.setObject(1, ldt);