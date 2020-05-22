List<Visits> visits = ...;

Map<Tuple3<String, String, String>, List<Visits>> grouped = visits.stream().collect(
    Collectors.groupingBy(
        visit ->
            Tuple.of(
                visit.getAgendaCode(),
                visit.getVisitTypeCode(),
                visit.getScheduledTime()
            )
    )
);