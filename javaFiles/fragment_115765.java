String enter = "2017-08-13 15:30:30";
String leave = "2017-08-17 22:00:00";

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
LocalDateTime start = LocalDateTime.parse(enter, formatter);
LocalDateTime end = LocalDateTime.parse(leave, formatter);

Duration duration = Duration.between(LocalDateTime.of(start.toLocalDate().plusDays(1), LocalTime.of(0, 0)), LocalDateTime.of(end.toLocalDate(), LocalTime.of(0, 0)));

Duration timeDuringDay = Duration.ofDays(0);
Duration timeDuringNight = Duration.ofDays(0);

// take care of all full days
long days;
if ((days = duration.toHours() / 24L) > 0) {
    timeDuringDay = timeDuringDay.plusHours(15 * days);
    timeDuringNight = timeDuringNight.plusHours(9 * days);
}

// take care of the first day
if (start.isBefore(LocalDateTime.of(start.toLocalDate(), LocalTime.of(6, 0)))) {
    timeDuringNight = timeDuringNight.plus(Duration.between(start, LocalDateTime.of(start.toLocalDate(), LocalTime.of(6, 0))));
    timeDuringNight = timeDuringNight.plus(Duration.ofHours(3));
    timeDuringDay = timeDuringDay.plusHours(15);
} else if (start.isAfter(LocalDateTime.of(start.toLocalDate(), LocalTime.of(21, 0)))) {
    timeDuringNight = timeDuringNight.plus(Duration.between(start, LocalDateTime.of(start.toLocalDate().plusDays(1), LocalTime.of(0, 0))));
} else {
    timeDuringDay = timeDuringDay.plus(Duration.between(start, LocalDateTime.of(start.toLocalDate(), LocalTime.of(21, 0))));
    timeDuringNight = timeDuringNight.plusHours(3);
}   

// take care of the last day
if (end.isBefore(LocalDateTime.of(end.toLocalDate(), LocalTime.of(6, 0)))) {
    timeDuringNight = timeDuringNight.plus(Duration.between(LocalDateTime.of(end.toLocalDate(), LocalTime.of(0, 0)), end));
} else if (end.isAfter(LocalDateTime.of(end.toLocalDate(), LocalTime.of(21, 0)))) {
    timeDuringNight = timeDuringNight.plusHours(6);
    timeDuringNight = timeDuringNight.plus(Duration.between(LocalDateTime.of(end.toLocalDate(), LocalTime.of(21, 0)), end));
    timeDuringDay = timeDuringDay.plusHours(15);
} else {
    timeDuringNight = timeDuringNight.plusHours(6);
    timeDuringDay = timeDuringDay.plus(Duration.between(LocalDateTime.of(end.toLocalDate(), LocalTime.of(6, 0)), end));
}

System.out.println("Time during day: " + timeDuringDay);
System.out.println("Time during night: " + timeDuringNight);