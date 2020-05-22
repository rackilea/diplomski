import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.servlet.NoHandlerFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import RequestBlockedException;

@ControllerAdvice
public final class ErrorController
{
    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(ErrorController.class.getName());

    /**
     * Generates an Error page by intercepting exceptions generated from AnnotatingHttpFirewall.
     *
     * @param request The original HTTP request.
     * @param ex A RequestBlockedException exception.
     * @return The tile definition name for the page.
     */
    @ExceptionHandler(RequestBlockedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleRequestBlockedException(final RequestBlockedException ex)
    {
        if (LOGGER.isLoggable(Level.WARNING))
        {
            LOGGER.log(Level.WARNING, "Rejected request from " + ex.getRemoteAddress() + " for [" + ex.getRequestUrl() + "]. Reason: " + ex.getReason());
        }

        // Note: Perform any additional business logic or logging here.

        return "errorPage"; // Returns a nice error page with the specified status code.
    }

    /**
     * Generates a Page Not Found page.
     *
     * @param ex A NoHandlerFound exception.
     * @return The tile definition name for the page.
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleException(final NoHandlerFoundException ex)
    {
        return "notFoundPage";
    }
}