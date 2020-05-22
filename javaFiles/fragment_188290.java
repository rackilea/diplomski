@Test
public void testCreateAndMergePdfs() throws IOException {
    Collection<File> pdfs = new ArrayList<>(Arrays.asList(createPdf("File1"), createPdf("File2")));
    assertFalse(CollectionUtils.isEmpty(pdfs));
    PdfPrintPojo pdfPrintPojo = new PdfPrintPojo(pdfs);
    File mergedFile = service.createAndMergePDFs(pdfPrintPojo, "Merged");
    assertNotNull(mergedFile);
    List<File> list = new ArrayList<>(pdfs);

    /* Load the PDF files and extract data as String. */
    PDDocument document1 = PDDocument.load(list.get(0));
    PDDocument document2 = PDDocument.load(list.get(1));
    PDDocument merged = PDDocument.load(mergedFile);

    PDFTextStripper stripper = new PDFTextStripper();
    String file1Data = stripper.getText(document1);
    String file2Data = stripper.getText(document2);
    String mergedData = stripper.getText(merged);

    /* Assert that data from file 1 and 2 are equal with each other and merged file. */
    assertEquals(file1Data, file2Data);
    assertEquals(file1Data + file2Data, mergedData);
}