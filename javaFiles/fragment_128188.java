public List<Result> listResultsForCompetition(String competitionName) {
    Map<Integer, Set<Result>> participantResults = new HashMap<>();

    for (Result result : resultList) {
        int participantId = result.getParticipant().getId();

        if (!participantResults.containsKey(participantId))