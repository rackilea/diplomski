public static void main(String[] args) {
  double dur = 1442.7; //hrs
  java.time.Duration d = java.time.Duration.ofMinutes((long) dur);
  System.out.println(format(d)); //PT24H2M0S
}

public static String format(java.time.Duration duration) {
  long seconds = duration.getSeconds();
  long absSeconds = Math.abs(seconds);
  String positive = String.format(
          "PT%dH%dM%dS",
          absSeconds / 3600,
          (absSeconds % 3600) / 60,
          absSeconds % 60);
  return seconds < 0 ? "-" + positive : positive;
}