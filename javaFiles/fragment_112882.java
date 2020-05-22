@Public public void retrieveKmlInOldFormat(){
 File file = new File(Play.applicationPath+"/"+Play.configuration.getProperty("web.content", "../bspb-web")+"/map/map.kml");
 String kmlFileContent = null;
 try {
   String kmlUrl = file.toURI().toURL().toString();
   kmlFileContent = BSPBKml2OldFormatConverter.toOldKml(kmlParserLocal.load(kmlUrl));
 } catch (MalformedURLException e) {
   e.printStackTrace();
 }
 response.setContentTypeIfNotSet("application/vnd.google-earth.kmz");
 response.setHeader("Content-Disposition", "attachment; filename=\"old_fmt_map.kmz\"");
 renderAsKmz(response, kmlFileContent,"old_fmt_map.kml");
 return;
}



private void renderAsKmz(Response response,String kmlFileContent,String zipEntryName){
 ZipOutputStream zipStream = new ZipOutputStream(response.out);
 ZipEntry zipEntry = new ZipEntry(zipEntryName);
 try {
  zipStream.putNextEntry(zipEntry);
  zipStream.write(kmlFileContent.getBytes());
 } catch (IOException e) {
   logger.error("Error while zipping kml file content : " + e.getMessage());
 }
 finally {
   try {
     zipStream.closeEntry();
     zipStream.close();
   } catch (IOException e) {
    logger.error("Error while closing zipped stream : " + e.getMessage());
  }
}