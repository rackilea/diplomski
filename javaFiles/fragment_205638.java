package somepackage.client.response;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;

import org.glassfish.jersey.message.MessageBodyWorkers;
import org.slf4j.Logger;

public class ResponseFilter implements ClientResponseFilter {

    @Inject
    private MessageBodyWorkers workers;
    private Logger logger;

    @Override
    public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext)
            throws IOException {
        if (responseValid(responseContext)) {
            return;
        }
        logger.error("Error", "Some param");
    }

    private boolean responseValid(ClientResponseContext responseContext) {
        if (responseContext.getStatus() == HttpServletResponse.SC_OK) {
            return true;
        }
        return false;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

}