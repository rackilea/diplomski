public class TokenInterceptor implements Interceptor {

    private String token;

    public String getToken() {
        return token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

            // Request customization: add request headers
            Request.Builder requestBuilder = original.newBuilder()
                    .header("Cache-Control", "no-cache")
                    .header("Accept", "application/json")
                    .method(original.method(), original.body());
            if (getToken() != null) {
                requestBuilder.header("Authorization", "Bearer " + AmzToken);
            }
            Request request = requestBuilder.build();
            return chain.proceed(request);
    }

    public void setToken(String token) {
        this.token = token;
    }
}