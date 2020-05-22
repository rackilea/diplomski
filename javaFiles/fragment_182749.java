static Condition and(Collection<? extends Condition> conditions) {
    Condition result = DSL.trueCondition();

    for (Condition condition : conditions)
        result = result.and(condition);

    return result;
}