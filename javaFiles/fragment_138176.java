public static void main(String args[]) throws Exception {

    FileInputStream is = null;
    try {
      File f = new File("C:/Temp/mime/abc.mp4");
      is = new FileInputStream(f);

      ContentHandler contenthandler = new BodyContentHandler();
      Metadata metadata = new Metadata();
      metadata.set(Metadata.RESOURCE_NAME_KEY, f.getName());
      Parser parser = new AutoDetectParser();
      // OOXMLParser parser = new OOXMLParser();
      parser.parse(is, contenthandler, metadata);
      System.out.println("Mime: " + metadata.get(Metadata.CONTENT_TYPE));
      System.out.println("Title: " + metadata.get(Metadata.TITLE));
      System.out.println("Author: " + metadata.get(Metadata.AUTHOR));
      System.out.println("content: " + contenthandler.toString());
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
        if (is != null) is.close();
    }
  }