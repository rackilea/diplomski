/**
 * This class is only used to solve cases where a Client gets stuck in a redirect process.
 */
public class MyClientFilter extends ClientFilter {

    @Override
    public ClientResponse handle(ClientRequest clientRequest) throws ClientHandlerException {
        return getNext().handle(clientRequest);
    }
}