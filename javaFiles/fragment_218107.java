public enum RequiredFields {
    REQUIRED_FIELDS_FOR_DELIVERABLE_PRODUCTS( Fields.NAME, Fields.EMAIL, Fields.ADDRESS ),
    REQUIRED_FIELDS_FOR_DOWNLOADABLE_PRODUCTS( Fields.NAME, Fields.EMAIL );

    private List<String> fields;
    private RequiredFields(String... fields){
        this.fields = Arrays.asList(fields);
    }
    public List<String> getFields(){
        return fields;
    }
}