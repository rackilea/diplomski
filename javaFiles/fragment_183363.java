public class FallbackCall() {

    private String hostname;

    private String secondaryHostname;

    private FallbackQuery next;

    public ClientResponse call(boolean remote, boolean secondary) {
        ClientResponse response = getResponse(hostname);
        if (response == null && secondary) {
            reponse = getResponse(secondaryHostname);

        }
        if (response == null && remote) {
            reponse = next.call(remote, secondary);

        }
        return response;
    }

    private ClientResponse getResponse(String hostname) {
        // your boiler plate
    }

}