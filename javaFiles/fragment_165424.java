class MyClass{
    ...
    HttpStatus httpStatus = HttpStatus.OK //from org.springframework.http
    @JsonIgnore
    public HttpStatus getHttpStatus() {
        return httpStatus;
     }

    @JsonProperty(value = "HttpStatus")
    @JsonDeserialize(using = HttpStatusDeserializer.class)
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
    ....
}