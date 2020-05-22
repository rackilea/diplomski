public Stream<SeasonBuilder> addWeeks(
    final Set<Set<ImmutablePair<Integer, Integer>>> possibleWeeks) {
        return possibleWeeks.stream()
                .filter(containsMatchup())   // Finds the weeks to add
                .map(this::addWeek);   // Create new SeasonBuilders with the new week
}