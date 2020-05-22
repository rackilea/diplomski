public class ProtocolFixRequest extends HttpServletRequestWrapper {

    private final String fixedProtocol;

    public ProtocolFixRequest(HttpServletRequest request, String protocol) {
        super(request);
        fixedProtocol = protocol;
    }

    @Override
    public String getProtocol() {
        return fixedProtocol;
    }
}