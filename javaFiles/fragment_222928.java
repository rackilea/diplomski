public class SampleHttpServletRequest 

        extends HttpServletRequestWrapper {

  private ByteArrayOutputStream cachedBytes;

  public SampleHttpServletRequest(HttpServletRequest request) {
    super(request);
  }

  @Override
  public ServletInputStream getInputStream() throws IOException {
    if (cachedBytes == null)
      cacheInputStream();

      return new CachedServletInputStream();
  }

  @Override
  public BufferedReader getReader() throws IOException{
    return new BufferedReader(new InputStreamReader(getInputStream()));
  }

  private void cacheInputStream() throws IOException {
    cachedBytes = new ByteArrayOutputStream();
    IOUtils.copy(super.getInputStream(), cachedBytes);
  }

  public class CachedServletInputStream extends ServletInputStream {
    private ByteArrayInputStream input;

    public CachedServletInputStream() {
      input = new ByteArrayInputStream(cachedBytes.toByteArray());
    }

    @Override
    public int read() throws IOException {
      return input.read();
    }
  }
}