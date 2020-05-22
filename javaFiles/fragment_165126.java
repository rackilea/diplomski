List<Visits> visits = ...;

final Map<Tuple3<String, String, String>, List<Visits>> grouped =
    visits.groupBy(visit ->
        Tuple.of(
            visit.getAgendaCode(),
            visit.getVisitTypeCode(),
            visit.getScheduledTime()
        )
    );