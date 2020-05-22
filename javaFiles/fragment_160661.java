InputStream data = new BufferedInputStream(realResponse.getEntity().getContent());
// data.markSupported() should return "true" now
data.mark(some_size);
// work with "data" now
...
data.reset();