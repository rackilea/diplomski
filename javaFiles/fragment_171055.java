String path = "D:\\priya_Docs\\Android pdfs\\Professional_Android_Application_Development.pdf";
    File file = new File(path);
    System.out.println("Located a file " + file.isFile());
    String filesArray = file.getPath();
    File getFile = file.getAbsoluteFile();
    FileInputStream fis = new FileInputStream(getFile);
    FileOutputStream fos = new FileOutputStream(
            "D:\\priya_Docs\\Androiddoc.pdf");
    byte[] buff=new byte[1024];
    int len;
    while((len=fis.read(buff))>=0) {
        fos.write(buff,0,len);
    }

    fis.close();
    fos.close();