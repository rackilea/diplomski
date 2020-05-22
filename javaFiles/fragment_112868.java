public class HeaderInterceptor implements Interceptor {

    SharedPrefManager sharedPrefManager = new SharedPrefManager();

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request originalRequest = chain.request();

        Request newRequest = originalRequest.newBuilder()
                .header("Language", sharedPrefManager.getSPToken())
                .build();

        return chain.proceed(newRequest);

    }
}