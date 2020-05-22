URI partial = new URI(
    null, // scheme
    null, // user info
    uri.getHost(),
    uri.getPort(),
    uri.getPath(),
    null, // query
    null); // fragment
String text = partial.toString();