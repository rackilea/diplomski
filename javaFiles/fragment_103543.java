class RefreshAccessTokenInterceptor
@Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(retryRequest(chain))
        return if (response.noAuthError()) {
            response
        } else {
            updateIfNeededOrProcessWithNewToken(chain)
        }
    }

    private fun retryRequest(chain: Interceptor.Chain): Request {
        val builder = chain.request().newBuilder()
        addAuthHeaders(builder)
        return builder.build()
    }

    private fun Response.noAuthError() = code() != HttpErrorChecker.HTTP_AUTHENTICATION_TIMEOUT

    private fun addAuthHeaders(builder: Request.Builder) {
        val accessToken = getAccessToken()
        if (!accessToken.isNullOrEmpty()) {
            builder.header("Authorization", "Bearer $accessToken")
        }
    }

    private fun updateIfNeededOrProcessWithNewToken(chain: Interceptor.Chain): Response {
        //here you update your token, add new header and retries request

        return chain.proceed(retryRequest(chain))
    }
}