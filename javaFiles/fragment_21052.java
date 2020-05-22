LocalDateTime now = LocalDateTime.now();
LocalDateTime before = now.minusMonths(1).minusDays(5).minusHours(2).minusMinutes(30);
Period p = Period.between(before.toLocalDate(), now.toLocalDate());
Duration d = Duration.between(before.toLocalTime(), now.toLocalTime());

System.out.println(p + " + " + d);