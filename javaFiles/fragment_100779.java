import fi.iki.elonen.NanoHTTPD;
import in.ashish29agre.androidnanohttpd.services.WebService;

/**
 * Created by Ashish on 10/01/16.
 */
public class Server extends NanoHTTPD {
    private static final String APPLICATION_JSON = "application/json";

    public Server(int port) {
        super(port);
    }

    public Server(String hostname, int port) {
        super(hostname, port);
    }

    @Override
    public Response serve(IHTTPSession session) {
        return new WebService(session).get();
    }

}