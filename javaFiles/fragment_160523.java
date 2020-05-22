Optional<Subject> filtered = getSubjects()
  .stream().filter(s -> s.getName().equalsIgnoreCase("Math"))
  //Find first is just one of the many Stream methods
  //returning an optional
  //It's correct to use it in this case because you know
  //only one value is expected to match the filter predicate.
  .findFirst();