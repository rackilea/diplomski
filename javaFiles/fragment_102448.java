Maybe<Integer> getCorrectSafeCombination() {
    return getPossibleCombinations()
            .toObservable()
            .flatMapIterable(combinations -> combinations)
            //this one
            .concatMap(combination -> tryToOpenSafeWithCombination(combination).toObservable()
                    .map(isCorrect -> new CombinationCheckResult(combination, isCorrect)))
            .filter(result -> result.isCorrect)
            .map(result -> result.combination)
            .firstElement();

}