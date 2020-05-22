@Override public final InputStream getInputStream() throws IOException {
    if (!doInput) {
      throw new ProtocolException("This protocol does not support input");
    }

    HttpEngine response = getResponse();

    // if the requested file does not exist, throw an exception formerly the
    // Error page from the server was returned if the requested file was
    // text/html this has changed to return FileNotFoundException for all
    // file types
    if (getResponseCode() >= HTTP_BAD_REQUEST) {
      throw new FileNotFoundException(url.toString());
    }

    return response.getResponse().body().byteStream();
}

 /**
 * Returns an input stream from the server in the case of error such as the requested file (txt,
 * htm, html) is not found on the remote server.
 */
 @Override public final InputStream getErrorStream() {
  try {
  HttpEngine response = getResponse();
      if (HttpEngine.hasBody(response.getResponse())
          && response.getResponse().code() >= HTTP_BAD_REQUEST) {
        return response.getResponse().body().byteStream();
      }
      return null;
    } catch (IOException e) {
      return null;
    }
}