public enum RecordStatusEnum {
    CREATED(EnumSet.of(Condition.A, Condition.B),
            EnumSet.of(Condition.C)),
    INSERTED(EnumSet.of(Condition.C),
             EnumSet.of(Condition.B),
    FAILED(EnumSet.noneOf(Condition.class),
           EnumSet.noneOf(Condition.class));

    private Set<Condition> successConditions;
    private Set<Condition> modificationConditions;

    RecordStatusEnum(Set<Condition> successConditions,
                     Set<Condition> modificationConditions) {
        this.successConditions = successConditions;
        this.modificationConditions = modificationConditions;
    }

    public boolean isSuccess(Condition c) {
        return successConditions.contains(c);
    }

    public boolean canBeModified(Condition c) {
        return modificationConditions.contains(c);
    }
}