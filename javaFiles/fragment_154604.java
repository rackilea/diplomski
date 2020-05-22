SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
simpleDateFormat.setLenient(false);
DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
try {
    System.out.println("SFD: " + simpleDateFormat.parse(date));
} catch (Exception e) {
    System.err.println("SDF failed");
}
try {
    System.out.println("DTF: " + dateTimeFormatter.parse(date));
} catch (Exception e) {
    System.err.println("DTF failed");
}