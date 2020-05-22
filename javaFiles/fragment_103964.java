PdfReader reader = new PdfReader(main_file);
PdfReader reader2 = new PdfReader(to_be_inserted);
// Create a stamper
PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
// Create an imported page to be inserted
PdfImportedPage page = stamper.getImportedPage(reader2, 1);
stamper.insertPage(p, reader2.getPageSize(1));
stamper.getUnderContent(i).addTemplate(page, 0, 0);
// Close the stamper and the readers
stamper.close();
reader.close();
reader2.close();