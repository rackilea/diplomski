public void FileUpload(FileUploadEvent event) throws ParseException  {
    UploadedFile item = event.getUploadedFile();
    InputStream originalInputStream = item.getInputStream();

    byte[] buffer = IOUtils.toByteArray(originalInputStream);
    InputStream is1 = new ByteArrayInputStream(buffer);
    InputStream is2 = new ByteArrayInputStream(buffer);

    Workbook workbook = org.apache.poi.ss.usermodel.WorkbookFactory.create(is1);
}

InputStream inptest = is2;
ps.setBinaryStream(2,fin,fin.available());