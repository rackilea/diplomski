public String solution(String Dt) {
    final DateTimeFormatter in = new DateTimeFormatterBuilder()
        .appendPattern("MMMM dd, yyyy K:mm a")
        .toFormatter(Locale.US);
    final DateTimeFormatter out = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
    return out.format(in.parse(Dt));
}