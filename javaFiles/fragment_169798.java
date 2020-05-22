public <T> T throwExceptionIfFailure(T res) {
    Response result = (Response<?>) res;
    if (!result.isSuccessful()) {
        try {
            String msg = result.errorBody().string();
            if (result.code() == 401 || result.code() == 403) {
                invalidateToken();
                msg = context.getString(R.string.invalid_credential);
            } else if (result.code() == 502) {
                msg = context.getString(R.string.server_down);
            }

            throw Exceptions.propagate(new IOException(msg));
        } catch (Throwable e) {
            throw Exceptions.propagate(e);
        }
    } else {
        return res;
    }
}