{
    File outputfile = new File("E:\\Java\\Sample.jpg");
    FileOutputStream fos = new FileOutputStream(outputfile);
    ImageIO.write(img, "jpg", outputfile);
    fos.flush();
    fos.close()
 }