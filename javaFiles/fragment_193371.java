Period period = new Period(1, 6, 2, 2, 5, 4, 3, 100);

// apply the period starting right now
Duration duration = period.toDurationFrom(new DateTime());

System.out.println(duration.toStandardSeconds().getSeconds() / 60.0);

// outputs 810964.05 (when right now is "2012-01-09T13:36:43.880-06:00")