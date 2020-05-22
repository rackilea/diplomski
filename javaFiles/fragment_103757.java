final class ApplicationError {

    final int code;
    final String message;
    final String description;

    ApplicationError(final ErrorCode errorCode, final String description) {
        this.code = errorCode.code;
        this.message = errorCode.message;
        this.description = description;
    }

    ...

    final ErrorCode resolveErrorCode() {
        final ErrorCode errorCode = ErrorCode.valueByCode(code);
        if ( !errorCode.message.equals(message) ) {
            throw new AssertionError('wow...');
        }
        return errorCode;
    }

}