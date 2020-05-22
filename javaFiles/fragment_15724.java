public class HostForceValve extends ValveBase {

private final String proxyName;

public HostForceValve(String proxyName) {
    this.proxyName = proxyName;
}

@Override public void invoke(Request request, Response response) throws IOException, ServletException {
    org.apache.coyote.Request coyoteRequest = request.getCoyoteRequest();
    MimeHeaders mimeHeaders = coyoteRequest.getMimeHeaders();
    mimeHeaders.removeHeader("host");
    final MessageBytes host = mimeHeaders.addValue("host");
    host.setString(proxyName);
    request.setRemoteHost(proxyName);
    request.getCoyoteRequest().serverName().setString(proxyName);
    try {
        Valve next = getNext();
        if (null == next) {
            return;
        }
        next.invoke(request, response);
    } finally {
        request.setRemoteHost(proxyName);
    }

}
}