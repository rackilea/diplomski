ClassLoader classloader =
     org.apache.poi.poifs.filesystem.POIFSFileSystem.class.getClassLoader();
URL res = classloader.getResource(
         "org/apache/poi/poifs/filesystem/POIFSFileSystem.class");
String path = res.getPath();
System.out.println("POI Core came from " + path);

classloader = org.apache.poi.POIXMLDocument.class.getClassLoader();
res = classloader.getResource("org/apache/poi/POIXMLDocument.class");
path = res.getPath();

System.out.println("POI OOXML came from " + path);

classloader = org.apache.poi.hslf.usermodel.HSLFSlideShow.class.getClassLoader();
res = classloader.getResource("org/apache/poi/hslf/usermodel/HSLFSlideShow.class");
path = res.getPath();
System.out.println("POI Scratchpad came from " + path);