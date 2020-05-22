interface IApiResponseConsumer<T> {

    void acceptSuccess(T data);

    void acceptFailure(List<ApiResponseError> errors);

}