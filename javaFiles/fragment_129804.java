PdfReader reader = new PdfReader (inputStream);
reader.selectPages("1-30");
ByteArrayOutputStream os = new ByteArrayOutputStream();
PdfStamper stamper = new PdfStamper(reader, os);
stamper.close();
byte[] changedPdf = os.toByteArray();