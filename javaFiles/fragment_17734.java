/* Returns the date that got the most 'YES' votes */
public Optional<LocalDateTime> getWinningDate() {
    return votes.entrySet() // Set<Entry<LocaleDateTime, Set<Vote>>
            .stream() // Stream<Entry<LocaleDateTime, Set<Vote>>
            .flatMap(e -> e.getValue().stream().filter(a -> a.getVote() == VoteType.YES)
                         .map(x -> e.getKey())) // Stream<LocalDateTime>
           .collect(groupingBy(Function.identity(), counting())) // Map<LocaleDateTime, Long>
           .entrySet() // Set<Entry<LocaleDateTime, Long>>
           .stream() // Stream<Entry<LocaleDateTime, Long>>
           .max(Comparator.comparingLong(Map.Entry::getValue)) // Optional<Entry<LocaleDateTime, Long>>
           .map(Map.Entry::getKey); // Optional<LocalDateTime>
}