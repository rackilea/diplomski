public class TestPdf {

    PDDocument document = new PDDocument();
    // Create a new blank page and add it to the document
    PDPage blankPage = new PDPage();

    public void createDocument()throws Exception {
        document.addPage(blankPage);
        // Save the newly created document
        document.save("BlankPage.pdf");
        // finally make sure that the document is properly
        // closed.
        document.close();
    }
}