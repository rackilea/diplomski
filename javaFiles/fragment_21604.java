public static class Interceptor<T extends BaseResponse> implements Callback<T> {

    public Interceptor(Callback<T> originalCaller) {
        this.originalCaller = originalCaller;
    }

    private Callback<T> originalCaller;

    @Override
    public void onResponse(T response) {
        originalCaller.onResponse(response);
    }

    ...
}