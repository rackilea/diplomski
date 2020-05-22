public class QueryParameterCompressionInterceptor implements Interceptor {

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();

        HttpUrl url = request.url();
        for (String parameterName : url.queryParameterNames()) {
            List<String> queryParameterValues = url.queryParameterValues(parameterName);

            if (queryParameterValues.size() > 1) {
                String formattedValues= "[" + TextUtils.join(",", queryParameterValues) + "]";

                request = request.newBuilder()
                        .url(
                                url.newBuilder()
                                        .removeAllQueryParameters(parameterName)
                                        .addQueryParameter(parameterName, formattedValues)
                                        .build()
                        ).build();
            }
        }

        return chain.proceed(request);
    }