private String getXmlFile(String pathFile){

  String xmlFileString = null;
  AssetManager am = context.getAssets();
  try {
    InputStream str = am.open(pathFile);
    int length = str.available();
    byte[] data = new byte[length];
   //str.what you want somthing to do...eg read and write str.read(data); and   st.write(data);
    xmlFileString = new String(data);
      } catch (IOException e1) {
        e1.printStackTrace();
     }

   return xmlFileString;
     }