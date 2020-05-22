String string = ... // some string which has to be validated

try {
  // WORKAROUND: add any scheme to make the resulting URI valid.
  URI uri = new URI("my://" + string); // may throw URISyntaxException
  String host = uri.getHost();
  int port = uri.getPort();

  if (uri.getHost() == null || uri.getPort() == -1) {
    throw new URISyntaxException(uri.toString(),
      "URI must have host and port parts");
  }

  // here, additional checks can be performed, such as
  // presence of path, query, fragment, ...


  // validation succeeded
  return new InetSocketAddress (host, port);

} catch (URISyntaxException ex) {
  // validation failed
}