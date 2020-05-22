public Map<String, DoubleSummaryStatistics> createStats(Map<String, List<Runner>> times) {
    return times.entrySet().stream()
          .collect(Collectors.toMap(Map.Entry::getKey,
                  e ->e.getValue().stream()
                          .map(Runner::getTime)
                          .mapToDouble(LocalTime::toSecondOfDay) // inverse while extrating summary details
                          .summaryStatistics()));
}