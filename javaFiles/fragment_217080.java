Instant inst = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
Timestamp ts = Timestamp.from(inst);

System.out.println(inst);
System.out.println(ts);
System.out.println(inst.toEpochMilli());
System.out.println(ts.getTime());