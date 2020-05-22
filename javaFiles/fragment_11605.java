FileResolver fileResolver = new FileResolver() {

     @Override
     public File resolveFile(String fileName) {
        URI uri;
        try {
          uri = new URI(this.getClass().getResource(fileName).getPath());
          return new File(uri.getPath());
        } catch (URISyntaxException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          return null;
        }
    }
};