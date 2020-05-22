final class ApplicationError {

    @JsonAdapter(FlatErrorCodeTypeAdapter.class)
    final ErrorCode code;
    final String description;

    ApplicationError(final ErrorCode code, final String description) {
        this.code = code;
        this.description = description;
    }

}