public class DocuSignAuthenticator implements ClientRequestFilter {

    private String user;
    private String password;
    private String integatorKey;
    private String sendBehalfOf;

    public DocuSignAuthenticator(String username, String password, 
                                 String integatorKey, String sendBehalfOf) {
        this.username = username;
        this.password = password;
        this.integatorKey = integatorKey;
        this.sendBehalfOf = sendBehalfOf;
    }

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        requestContext.getHeaders().add(
            "X-DocuSign-Authentication", getAuthenticationHeader());
    }

    private String getAuthenticationHeader() {

        StringBuilder builder = new StringBuilder();
        builder.append("<DocuSignCredentials>");

        builder.append("<SendOnBehalfOf>");
        builder.append(sendBehalfOf);
        builder.append("</SendOnBehalfOf>");

        builder.append("<Username>");
        builder.append(username);
        builder.append("</Username>");

        builder.append("<Password>");
        builder.append(password);
        builder.append("</Password>");

        builder.append("<IntegratorKey>");
        builder.append(integatorKey);
        builder.append("</IntegratorKey>");

        builder.append("</DocuSignCredentials>");
        return builder.toString();
    }
}