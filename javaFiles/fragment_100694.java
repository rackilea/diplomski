class Sample {
    private String prop1;
    private String prop2;
    @JsonIgnore // could be here
    private String prop3;

    @JsonIgnore // could be here
    public String getProp3() {
        return prop3;
    }
}