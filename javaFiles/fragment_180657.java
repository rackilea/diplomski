/**
 * A custom exception for situations where a request is blocked or rejected.
 */
public class RequestBlockedException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    /**
     * The requested URL.
     */
    private String requestUrl;

    /**
     * The remote address of the client making the request.
     */
    private String remoteAddress;

    /**
     * A message or reason for blocking the request.
     */
    private String reason;

    /**
     * The user agent supplied by the client the request.
     */
    private String userAgent;

    /**
     * Creates a new Request Blocked Exception.
     *
     * @param reqUrl The requested URL.
     * @param remoteAddr The remote address of the client making the request.
     * @param userAgent The user agent supplied by the client making the request.
     * @param message A message or reason for blocking the request.
     */
    public RequestBlockedException(final String reqUrl, final String remoteAddr, final String userAgent, final String message)
    {
        this.requestUrl = reqUrl;
        this.remoteAddress = remoteAddr;
        this.userAgent = userAgent;
        this.reason = message;
        return;
    }

    /**
     * Gets the requested URL.
     *
     * @return A URL.
     */
    public String getRequestUrl()
    {
        return this.requestUrl;
    }

    /**
     * Gets the remote address of the client making the request.
     *
     * @return A remote address.
     */
    public String getRemoteAddress()
    {
        return this.remoteAddress;
    }

    /**
     * Gets the user agent supplied by the client making the request.
     *
     * @return  A user agent string.
     */
    public String getUserAgent()
    {
        return this.userAgent;
    }

    /**
     * Gets the reason for blocking the request.
     *
     * @return  A message or reason for blocking the request.
     */
    public String getReason()
    {
        return this.reason;
    }
}