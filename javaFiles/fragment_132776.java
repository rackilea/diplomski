protected static int validateURI(String srvURI) {
    try {
        URI vURI = new URI(srvURI);
        if (!vURI.getPath().equals("")) {
            throw new IllegalArgumentException(srvURI);
        }
        if (vURI.getScheme().equals("tcp")) {
            return URI_TYPE_TCP;
        }
        else if (vURI.getScheme().equals("ssl")) {
            return URI_TYPE_SSL;
        }
        else if (vURI.getScheme().equals("local")) {
            return URI_TYPE_LOCAL;
        }
        else {
            throw new IllegalArgumentException(srvURI);
        }
    } catch (URISyntaxException ex) {
        throw new IllegalArgumentException(srvURI);
    }
}