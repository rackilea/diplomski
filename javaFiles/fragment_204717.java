repository
    .findByProductiondate(LocalDate.of(2018, 6, 6)).stream()
    .collect(Collectors.groupingBy(migration -> migration.getState().getState()))
    .entrySet().stream()
    .map(entry -> new StateSummaryDTO(
        entry.getKey(),
        entry.getValue().stream()
            .map(migration -> new MigrationDTO(
                migration.getMignum(),
                migration.getState().getProjectleader(),
                migration.getProductiondate(),
                migration.getInstallationtiers(),
                migration.getTargetplatform(),
                migration.getApprelated(),
                migration.getAppversion()))
        .collect(Collectors.toList())))
.collect(Collectors.toList());