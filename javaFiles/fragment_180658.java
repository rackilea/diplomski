import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Intercepts requests that were flagged as rejected by the firewall.
 */
public final class FirewallInterceptor implements HandlerInterceptor
{
    /**
     * Default constructor.
     */
    public FirewallInterceptor()
    {
        return;
    }

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception
    {
        if (Boolean.TRUE.equals(request.getAttribute(AnnotatingHttpFirewall.HTTP_HEADER_REQUEST_REJECTED)))
        {
            // Throw a custom exception that can be handled by a custom error controller.
            final String reason = (String) request.getAttribute(AnnotatingHttpFirewall.HTTP_HEADER_REQUEST_REJECTED_REASON);
            throw new RequestRejectedByFirewallException(request.getRequestURL().toString(), request.getRemoteAddr(), request.getHeader(HttpHeaders.USER_AGENT), reason);
        }

        return true; // Allow the request to proceed normally.
    }

    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final ModelAndView modelAndView) throws Exception
    {
        return;
    }

    @Override
    public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final Exception ex) throws Exception
    {
        return;
    }
}