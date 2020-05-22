add(new NonCachingImage("img", new AbstractReadOnlyModel<DynamicImageResource>(){
          @Override public DynamicImageResource getObject() {
            DynamicImageResource dir = new DynamicImageResource() {
              @Override protected byte[] getImageData(Attributes attributes) {
                  StringValue name = parameters.get("name");
                  byte[] imageBytes = null;
                    if(name.isEmpty() == false)
                        imageBytes = getImageAsBytes(name.toString());

                    return imageBytes;
              }
            };
            dir.setFormat("image/png");
            return dir;
          }
        }));

private byte[] getImageAsBytes(String label){
    byte[] imageBytes = null;
    try {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            InputStream inStream  = new FileInputStream(new File(label));
            copy(inStream, outStream);
            inStream.close();
            outStream.close();
            return outStream.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
          } 
     return imageBytes;


}

private void copy(InputStream source, OutputStream destination)
        throws IOException
    {

        // Transfer bytes from source to destination
            byte[] buf = new byte[1024];
            int len;
            while ((len = source.read(buf)) > 0) {
                destination.write(buf, 0, len);
            }
            source.close();
            destination.close();

    }