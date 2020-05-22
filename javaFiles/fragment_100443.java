abstract class ApiResponse<T> {

    // A bunch of protected methods, no interface needed as we're considering it's a value type and we don't want to expose any of them
    protected abstract boolean isSuccessful();

    protected abstract T getData()
            throws UnsupportedOperationException;

    protected abstract List<ApiResponseError> getErrors()
            throws UnsupportedOperationException;

    // Since we can cover all two cases ourselves, let them all be here in this class
    private ApiResponse() {
    }

    static <T> ApiResponse<T> success(final T data) {
        return new SucceededApiResponse<>(data);
    }

    static <T> ApiResponse<T> failure(final List<ApiResponseError> errors) {
        @SuppressWarnings("unchecked")
        final ApiResponse<T> castApiResponse = (ApiResponse<T>) new FailedApiResponse(errors);
        return castApiResponse;
    }

    // Despite those three protected methods can be technically public, let's encapsulate the state
    final void accept(final IApiResponseConsumer<? super T> consumer) {
        if ( isSuccessful() ) {
            consumer.acceptSuccess(getData());
        } else {
            consumer.acceptFailure(getErrors());
        }
    }

    // And make a couple of return-friendly accept methods
    final T acceptOrNull() {
        if ( !isSuccessful() ) {
            return null;
        }
        return getData();
    }

    final T acceptOrNull(final Consumer<? super List<ApiResponseError>> errorsConsumer) {
        if ( !isSuccessful() ) {
            errorsConsumer.accept(getErrors());
            return null;
        }
        return getData();
    }

    private static final class SucceededApiResponse<T>
            extends ApiResponse<T> {

        private final T data;

        private SucceededApiResponse(final T data) {
            this.data = data;
        }

        @Override
        protected boolean isSuccessful() {
            return true;
        }

        @Override
        protected T getData() {
            return data;
        }

        @Override
        protected List<ApiResponseError> getErrors()
                throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

    }

    private static final class FailedApiResponse
            extends ApiResponse<Void> {

        private final List<ApiResponseError> errors;

        private FailedApiResponse(final List<ApiResponseError> errors) {
            this.errors = errors;
        }

        @Override
        protected boolean isSuccessful() {
            return false;
        }

        @Override
        protected List<ApiResponseError> getErrors() {
            return errors;
        }

        @Override
        protected Void getData()
                throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

    }

}