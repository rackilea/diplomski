private static void demo(String from, String to) {
    ZoneId zone = ZoneId.of("Atlantic/Stanley");
    Duration overlapDuration = overlap(LocalDateTime.parse(from).atZone(zone),
            LocalDateTime.parse(to).atZone(zone));
    System.out.println("" + from + " - " + to + ": " + overlapDuration);
}