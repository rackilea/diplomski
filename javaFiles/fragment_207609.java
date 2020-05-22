response.setContentType("application/zip"); // application/octet-stream
response.setHeader("Content-Disposition", "inline; filename=\"all.zip\"");
try (ZipOutputStream zos = new ZipOutputStream(response.getOutputStream())) {
     for (int i = 0; i < 3; i++) {
         ZipEntry ze = new ZipEntry("document-" + i + ".pdf");
         zos.putNextEntry(ze);

         // It would be nice to write the PDF immediately to zos.
         // However then you must take care to not close the PDF (and zos),
         // but just flush (= write all buffered).
         //PdfWriter pw = PdfWriter.getInstance(document[i], zos);
         //...
         //pw.flush(); // Not closing pw/zos

         // Or write the PDF to memory:
         ByteArrayOutputStream baos = new ...
         PdfWriter pw = PdfWriter.getInstance(document[i], baos);
         ...
         pw.close();
         byte[] bytes = baos.toByteArray();
         zos.write(baos, 0, baos.length);

         zos.closeEntry();
     }
}