private static EndpointDescription updateEndpointUrl(
    EndpointDescription original, String hostname) throws URISyntaxException {

    URI uri = new URI(original.getEndpointUrl()).parseServerAuthority();

    String endpointUrl = String.format(
        "%s://%s:%s%s",
        uri.getScheme(),
        hostname,
        uri.getPort(),
        uri.getPath()
    );

    return new EndpointDescription(
        endpointUrl,
        original.getServer(),
        original.getServerCertificate(),
        original.getSecurityMode(),
        original.getSecurityPolicyUri(),
        original.getUserIdentityTokens(),
        original.getTransportProfileUri(),
        original.getSecurityLevel()
    );
}