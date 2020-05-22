@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
class RequestVO {
    String optional;

    public RequestVO(String optional) {
        this.optional = optional;
    }

    public String getOptional() {
        return optional;
    }

    public void setOptional(String optional) {
        this.optional = optional;
    }
}