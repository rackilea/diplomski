/** Your original method signature. No changes to any calling code. */
public List<DrawResultDto> getLastDrawResult(
    Optional<Long> lotteryId,
    Optional<String> name,
    Optional<String> byName,
    Optional<String> byDate,
    Optional<Boolean> jackpotOnly) {
  return getLastDrawResult(lotteryId, name, byName, byDate, jackpotOnly,
      Clock.systemDefaultZone());
}

/** Your original method implementation. Test this one. */
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