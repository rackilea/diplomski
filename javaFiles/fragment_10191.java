DateTime now = DateTime.now();
DateTime startOfDay = now.withTimeAtStartOfDay();
DateTime latest = startOfDay.plusMinutes(1); // tolerance, you can adjust it for your needs

if (new Interval(startOfDay, latest).contains(now)) {
  // do stuff
}