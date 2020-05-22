String enter = "2017-08-14 15:00:00";
String leave = "2017-08-17 12:00:00";

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
LocalDateTime start = LocalDateTime.parse(enter, formatter);
LocalDateTime end = LocalDateTime.parse(leave, formatter);
Duration duration = Duration.between(start, end);

int duringDay = 0;
int duringNight = 0;

// take care of all full days
long days;
if ((days = duration.toHours() / 24L) > 0) {
    duringDay += 15 * days;
    duringNight += 9 * days;
}

// take care of the remainder
for (int i = 1; i <= duration.toHours() % 24; i++) {
    LocalDateTime ldt = start.plusHours(i);
    if (ldt.getHour() <= 6 || ldt.getHour() > 21) {
        duringNight++;
    } else {
        duringDay++;
    }
}

System.out.println("Hours during day: " + duringDay);
System.out.println("Hours during night: " + duringNight);