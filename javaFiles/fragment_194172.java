import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.TimeZone;
import java.util.UUID;

@Component
public class RequestResponseLoggingFilter implements Filter {
    private FilterConfig filterConfig;
    private static String TZ_NAME = "timezoneOffset";

    private static final Logger LOGGER = LogManager.getLogger(RequestBody.class);


@Override
public void init(FilterConfig filterConfig) throws ServletException {
    this.filterConfig = filterConfig;
}

/**
 * Sample filter that populates the MDC on every request.
 */
@Override
public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest)servletRequest;
    HttpServletResponse response = (HttpServletResponse)servletResponse;

    String requestId = request.getHeader("requestId");

    if (requestId == null) {
        requestId = UUID.randomUUID().toString();
    }

    ThreadContext.put("requestId", requestId);
    ThreadContext.put("ipAddress", request.getRemoteAddr());
    HttpSession session = request.getSession(false);
    TimeZone timeZone = null;
    ThreadContext.put("hostname", servletRequest.getServerName());
    ThreadContext.put("locale", servletRequest.getLocale().getDisplayName());
    if (timeZone == null) {
        timeZone = TimeZone.getDefault();
    }
    ThreadContext.put("timezone", timeZone.getDisplayName());
    LOGGER.info(
            "Logging Request {} : {}", request.getMethod(),
            request.getRequestURI());
    filterChain.doFilter(servletRequest, servletResponse);
    LOGGER.info(
            "Logging Response {} : {}",
            response.getStatus(), response.getContentType());
    ThreadContext.clearMap();
}

@Override
public void destroy() {
}
}