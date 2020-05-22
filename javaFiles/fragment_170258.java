Seq<Tuple2<ScenState, Probability>> result =
  resultStateProbs.flatMap(tuple -> {
    Seq<Tuple2<ScenState, Probability>> filteredAndUpdated =
      tuple.apply((spv, baTargetCount) -> {
        Seq<StateProbability> stateProbList = spv.getStateProbList();

        stateProbList.peek(sp -> {
          logger.debug("Checking if {} > {}: {}", sp.getProbability(), intermediateMinProb, sp.getProbability().greaterThan(intermediateMinProb));
        });

        Seq<StateProbability> filtered = stateProbList.filter(sp ->
          sp.getProbability().greaterThan(intermediateMinProb));

        Seq<Tuple2<ScenState, Probability>> updated = filtered.map(sp ->
          updateScenarioData(sp, baTargetCount, dupStateInfo));

        return updated;
      });
    return filteredAndUpdated;
  });