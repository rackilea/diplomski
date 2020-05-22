public List<DrawResultDto> getLastDrawResult(
    Optional<Long> lotteryId,
    Optional<String> name,
    Optional<String> byName,
    Optional<String> byDate,
    Optional<Boolean> jackpotOnly,
    Clock clock) {
  LocalDateTime localDateTime = LocalDateTime.now(clock);
  /* ... */
}