participantResults.get(participantId).add(result);
    }

    Map<Integer, Result> topParticipantResults = new HashMap<>();

    for (Map.Entry<Integer, Set<Result>> entry : participantResults.entrySet())
        topParticipantResults.put(entry.getKey(), entry.getValue().iterator().next());

    List<Result> topResults = new ArrayList<>(topParticipantResults.values());

    return topResults;
}