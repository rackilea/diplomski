resp.setContentType("application/zip");
    // Indicate that a file is being sent back:
    resp.setHeader("Content-Disposition", "attachment;filename=test.zip");

    // workbook.write() closes the stream, so we first have to
    // write it to a "buffer", a ByteArrayOutputStream
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    workbook.write(baos);
    byte[] data = baos.toByteArray();

    try (ZipOutputStream out = new ZipOutputStream(resp.getOutputStream())) {
        // Here you can add your content to the zip 

        ZipEntry e = new ZipEntry("test.xlsx");
        // Configure the zip entry, the properties of the file
        e.setSize(data.length);
        e.setTime(System.currentTimeMillis());
        // etc.
        out.putNextEntry(e);
        // And the content of the XLSX:
        out.write(data);
        out.closeEntry();

        // You may add other files here if you want to

        out.finish();
    } catch (Exception e) {
        // Handle the exception
    }
}