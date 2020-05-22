final Set<String> makes = ImmutableSet.copyOf(makeList);
Predicate<CarObj> predMake2 = new Predicate<CarObj>() {
  @Override public boolean apply(CarObj car) {
    for (String make : makes) {
      if (car.getMake().startsWith(make)) {
        return true;
      }
    } 
    return false;
  }
};