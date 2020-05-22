public enum RecordStatusEnum {
    CREATED(Condition.A, Condition.B),
    INSERTED(Condition.C),   
    FAILED();

    private Set<Condition> successConditions;

    RecordStatusEnum(Condition... successConditions) {
        this.successConditions = EnumSet.copyOf(Arrays.asList(successConditions));
    }

    public boolean isSuccess(Condition c) {
        return successConditions.contains(c);
    }
}