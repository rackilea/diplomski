@GetMapping
public List<SimpleStateSummaryDTO> findSimple() {
    return repository
        .findByProductiondate(LocalDate.of(2018, 6, 6)).stream()
        .collect(Collectors.groupingBy(migration -> migration.getState().getState()))
        .entrySet().stream()
        .map(entry -> new SimpleStateSummaryDTO(entry.getKey(), entry.getValue().size()))
        .collect(Collectors.toList());
}