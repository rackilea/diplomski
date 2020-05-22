protected void updateDuration() {
    System.out.println(LocalDateTime.now());
    Duration d = Duration.between(releaseDate.atStartOfDay(), LocalDateTime.now());
    System.out.println(d.toMillis());
    long days = d.toDays();
    d = d.minusDays(days);
    long hours = d.toHours();
    d = d.minusHours(hours);
    long mins = d.toMinutes();
    d = d.minusMinutes(mins);
    long seconds = d.toMillis() / 1000;

    displayDateS.setText("Seconds: " + seconds);
    displayDateM.setText("Minutes: " + mins);
    displayDateH.setText("Hours: " + hours);
    displayDateD.setText("Days: " + days);
}