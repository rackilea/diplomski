/**
 * check account status
 * 
 * @param connectTimeout
 * @param readTimeout
 * @param writeTimeout
 * @param account
 * @return
 */
@GET("login/prelogin")
Observable<ResponseBody> preLogin(
        @Header("CONNECT_TIMEOUT") String connectTimeout,
        @Header("READ_TIMEOUT") String readTimeout,
        @Header("WRITE_TIMEOUT") String writeTimeout,
        @Query("account") String account);