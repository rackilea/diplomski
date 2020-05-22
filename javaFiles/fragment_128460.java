// replace the for-loop

// or just.... `newFiltersPositionsList.forEach(/* ... */)`
newFiltersPositionsList.stream().forEach(filterPosition -> {
    Optional<RiskFilters> filter_payload = filterList.stream()
            .filter(f -> filterPosition.getId() == f.getId())
            .findAny();
    RiskFilters filter = filter_payload.get();

    filter.setPosition(filterPosition.getPosition());
    riskFilterService.save(filter);
});