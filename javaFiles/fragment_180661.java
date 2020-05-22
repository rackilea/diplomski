import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
public final class FirewallController
{
    /**
     * The name of the model attribute (or request parameter for advertisement click tracking) that contains the request URL.
     */
    protected static final String REQUEST_URL = "requestUrl";

    /**
     * The name of the model attribute that contains the request method.
     */
    protected static final String REQUEST_METHOD = "requestMethod";

    /**
     * The name of the model attribute that contains all HTTP headers.
     */
    protected static final String REQUEST_HEADERS = "requestHeaders";

    /**
     * Default constructor.
     */
    public FirewallController()
    {
        return;
    }

    /**
     * Populates the request URL model attribute from the HTTP request.
     *
     * @param request The HTTP request.
     * @return The request URL.
     */
    @ModelAttribute(REQUEST_URL)
    public final String getRequestURL(final HttpServletRequest request)
    {
        return request.getRequestURL().toString();
    }

    /**
     * Populates the request method from the HTTP request.
     *
     * @param request The HTTP request.
     * @return The request method (GET, POST, HEAD, etc.).
     */
    @ModelAttribute(REQUEST_METHOD)
    public final String getRequestMethod(final HttpServletRequest request)
    {
        return request.getMethod();
    }

    /**
     * Gets all headers from the HTTP request.
     *
     * @param request The HTTP request.
     * @return The request headers.
     */
    @ModelAttribute(REQUEST_HEADERS)
    public final HttpHeaders getRequestHeaders(final HttpServletRequest request)
    {
        return FirewallController.headers(request);
    }

    /**
     * A catch-all default mapping that throws a NoHandlerFoundException.
     * This will be intercepted by the ErrorController, which allows preHandle to work normally.
     *
     * @param requestMethod The request method.
     * @param requestUrl The request URL.
     * @param requestHeaders The request headers.
     * @throws NoHandlerFoundException every time this method is invoked.
     */
    @RequestMapping(value = "/**") // NOTE: This prevents resolution of static resources. Still looking for a workaround for this.
    public void getNotFoundPage(@ModelAttribute(REQUEST_METHOD) final String requestMethod, @ModelAttribute(REQUEST_URL) final String requestUrl, @ModelAttribute(REQUEST_HEADERS) final HttpHeaders requestHeaders) throws NoHandlerFoundException
    {
        throw new NoHandlerFoundException(requestMethod, requestUrl, requestHeaders);
    }

    /**
     * Gets all headers from a HTTP request.
     *
     * @param request The HTTP request.
     * @return The request headers.
     */
    public static HttpHeaders headers(final HttpServletRequest request)
    {
        final HttpHeaders headers = new HttpHeaders();

        for (Enumeration<?> names = request.getHeaderNames(); names.hasMoreElements();)
        {
            final String headerName = (String) names.nextElement();

            for (Enumeration<?> headerValues = request.getHeaders(headerName); headerValues.hasMoreElements();)
            {
                headers.add(headerName, (String) headerValues.nextElement());
            }
        }

        return headers;
    }
}