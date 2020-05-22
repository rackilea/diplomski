InputStream is = entity.getContent();

// check if the response is gzipped
Header encoding = response.getFirstHeader("Content-Encoding");
if (encoding != null && encoding.getValue().equals("gzip")) {
    is = new GZIPInputStream(is);
}