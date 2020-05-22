public enum ConflictResolutionStrategy implements BiConsumer<CaseType, CaseType> {
    softResolve ((case1, case2) -> case1.update(case2)),
    hardResolve((case1, case2) -> {/* do something else */});

    private final BiConsumer<CaseType, CaseType> consumer;

    ConflictResolutionStrategy(BiConsumer<CaseType, CaseType> consumer){
        this.consumer = consumer;
    }

    @Override
    public void accept(CaseType case1, CaseType case2) {
        consumer.accept(case1, case2);
    }

}