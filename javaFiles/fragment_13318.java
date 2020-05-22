evaluators.stream()
    .flatMap(evaluator -> evaluator.getAnswers().stream())
    .collect(Collectors.groupingBy(
        answer -> new AbstractMap.SimpleEntry<>(answer.getEvaluator().getRelationship(), 
                                                answer.getQuestion().getGroupName()),
        Collectors.averagingInt(Answer::getValue)));