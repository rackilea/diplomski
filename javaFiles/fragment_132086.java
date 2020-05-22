public static class Type {
    private String code;

    private String description;

    @ApiField("raw-value")
    private String value;

    public Type() {
    }

    public Type(String code, String description, String value) {
        super();
        this.code = code;
        this.description = description;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}