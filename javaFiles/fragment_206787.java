private static final Object GZIP_CONTENT_TYPE = "gzip";

  public static InputStream urlExists(String url)
  {
    try
    {
      URL site = new URL(url);
      try
      {
        URLConnection conn = site.openConnection();
        if (GZIP_CONTENT_TYPE.equals(conn.getContentEncoding()))
        {
          System.out.println("Using gzip stream");
          return new GZIPInputStream(conn.getInputStream());
        }
        System.out.println("Using uncompressed stream");
        return conn.getInputStream();
      }
      catch (IOException ex)
      {
        return null;
      }
    }
    catch (MalformedURLException ex)
    {
      return null;
    }
  }