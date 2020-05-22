// Somewhere in your class:
Instant startDate(Activity activity) {
  return activity.getFields()
    .stream()
    .filter(field -> field.getKey().equals("startTime"))
    .map(field -> Instant.parse(field.getValue()))
    .findAny()
    .get();
}

// .. and then to use it:
Optional<Activity> maxStartDateActivity = activities()
    .stream()
    .max(Comparator.comparing(MyClass::startDate));