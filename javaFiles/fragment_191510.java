PdfReader reader = new PdfReader(baos.toByteArray());
int startToc = 13;
int n = reader.getNumberOfPages();
reader.selectPages(String.format("1,%s-%s, 2-%s, %s", startToc, n-1, startToc - 1, n));
PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
stamper.close();