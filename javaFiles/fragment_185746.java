public static ApiError parseError(Response<?> response) {
    Converter<ResponseBody, ApiError> converter = ServiceGenerator.retrofit().
            responseBodyConverter(ApiError.class, new Annotation[0]);

    ApiError apiError;

    try {
        apiError = converter.convert(response.errorBody());
    } catch (IOException e) {
        apiError = new ApiError();
    }

    return apiError;
}