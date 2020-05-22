import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.RoutingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReactAppHandler implements Handler<RoutingContext> {

    private static final Logger LOGGER = LogManager.getLogger(ReactAppHandler.class);

    private static final String WEB_ROOT_DIR = "webroot";
    private static final String INDEX_HTML = "/index.html";

    @Override
    public void handle(RoutingContext event) {

        HttpServerRequest request = event.request();
        String path = event.normalisedPath();

        LOGGER.info("Received a request for [" + path + "].");

        String requestedFilepath = path;

        if ("/".equals(requestedFilepath)) {
            LOGGER.info("Requested file is root path. Remapping to return the index page.");
            requestedFilepath = INDEX_HTML;
        }

        final String fileToCheck = WEB_ROOT_DIR + requestedFilepath;
        LOGGER.info("Checking if file exists at [" + fileToCheck + "].");

        event.vertx().fileSystem().exists(fileToCheck, fileExistsCheck -> {

            String fileToSend = WEB_ROOT_DIR + INDEX_HTML;

            if (fileExistsCheck.succeeded() && fileExistsCheck.result()) {
                LOGGER.info("File exists at path.");
                fileToSend = fileToCheck;
            } else {
                LOGGER.info("Could not find requested file, the index page will be returned instead.");
            }

            LOGGER.info("Returning file [" + fileToSend + "].");
            request.response().sendFile(fileToSend);
        });
    }
}