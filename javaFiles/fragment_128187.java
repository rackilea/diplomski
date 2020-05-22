Map<Integer, Result> topResults =  new LinkedHashMap<>();

for(Result result : tempResultList) {
    if(!topResults.containsKey(result.getParticipant().getId()))
        topResults.put(result.getParticipant().getId(), result);
}