/**
 * check account status
 *
 * @param account
 * @return
 */
@Headers({"CONNECT_TIMEOUT:10000", "READ_TIMEOUT:10000", "WRITE_TIMEOUT:10000"})
@GET("login/prelogin")
Observable<ResponseBody> preLogin(@Query("account") String account);