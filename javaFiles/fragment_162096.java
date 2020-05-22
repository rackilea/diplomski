try {
  // NOTE: you can move these into their own try/catch so you can handle bad user input separately if you wish
  final LocalTime time1 = LocalTime.parse(userInput1, DateTimeForamatter.ISO_LOCAL_TIME);
  final LocalTime time2 = LocalTime.parse(userInput2, DateTimeForamatter.ISO_LOCAL_TIME);
  final long differenceInNanos = (time2.toNanoOfDay() - time1.toNanoOfDay());
  final long differenceInSeconds = TimeUnit.NANOSECONDS.toSeconds(differenceInNanos)
}
catch(DateTimeParseException e){
   // TODO code to handle bad user input
}