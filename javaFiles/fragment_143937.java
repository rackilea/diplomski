timeslots.sort(null);  // sort the list using natural order
    if (IntStream.range(1, timeslots.size())
                 .map(i -> timeslots.get(i-1).compareTo(timeslots.get(i)))
                 .anyMatch(i -> i == 0)) {
        throw new IllegalArgumentException("...");
    }