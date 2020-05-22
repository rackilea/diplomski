try
{
    URL url = new URL("localhost:8080/testproject/downloads/fileName.doc");
    InputStream in = url.openStream();
    fs = new POIFSFileSystem(in);
    HWPFDocument doc = new HWPFDocument(fs);
    newFileName = request.getRealPath("") + "/downloads/newFile.doc";
    OutputStream writer = new FileOutputStream(newFileName);

    doc.getRange().replaceText("Location", "USA");
    doc.write(writer);
    writer.close();
}
catch(Exception e) 
{
    e.printStackTrace();
}