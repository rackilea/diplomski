private final StreamDecoder sd;

public InputStreamReader(InputStream in) {
  ...
  sd = StreamDecoder.forInputStreamReader(in, this, (String)null);
  ...
}

public void close() throws IOException {
  sd.close();
}