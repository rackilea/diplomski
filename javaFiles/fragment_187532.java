FileOutputStream masterBos = new FileOutputStream(VariabiliGlobali.PATH_TMP+"Tmp.zip");
    ZipOutputStream masterZos = new ZipOutputStream(masterBos);


public void zippatore(List<File> filesDaZippare, ZipOutputStream masterZos, String zipName, String pdfName) throws IOException{
    float newSize = 0;
    boolean first = true;
    int count = 1;
    File file;
    ByteArrayOutputStream subBaos = new ByteArrayOutputStream();
    ZipOutputStream subZos = new ZipOutputStream(subBaos);

    masterZos.putNextEntry(new ZipEntry(zipName+" "+count++ +".zip"));
    while(filesDaZippare.size() > 0){
        file = filesDaZippare.remove(0);
        FileInputStream fis = new FileInputStream(file);
        newSize += file.length();
        String fileName = file.getName().substring(2);
        if(newSize < MAX_SIZE || first){
            subZos.putNextEntry(new ZipEntry(pdfName+" "+fileName+".pdf"));
            IOUtils.copy(fis, subZos);
            file.delete();
            subZos.closeEntry();
            first = false;
        }else{
            subZos.flush();
            subZos.close();
            subBaos.flush();
            subBaos.close();

            masterZos.write(subBaos.toByteArray());
            masterZos.closeEntry();
            masterZos.putNextEntry(new ZipEntry(zipName+" "+count++ +".zip"));

            subBaos = new ByteArrayOutputStream();
            subZos = new ZipOutputStream(subBaos);
            subZos.putNextEntry(new ZipEntry(pdfName+" "+fileName+".pdf"));
            IOUtils.copy(fis, subZos);
            file.delete();

            newSize = file.length();
            first = true;
        }
        subZos.closeEntry();
    }
    subZos.closeEntry();
    subZos.flush();
    subZos.close();
    masterZos.write(subBaos.toByteArray());

    masterZos.closeEntry();
}