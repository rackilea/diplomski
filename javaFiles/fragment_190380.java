class ExtraFields {

    private String createdBy;

    public ExtraField(String createdBy) {
        this.createdBy = createdBy;
    }

    @AfterMapping
    public void afterFishGear(@MappingTarget fishGear) {
        fishGear.setCreatedBy(createdBy);
    }
}