public static void main(String[] args) throws IOException
{
    String formTemplate = "myFormPdf.pdf";

    try (PDDocument pdfDocument = PDDocument.load(new File(formTemplate)))
    {
        PDAcroForm acroForm = pdfDocument.getDocumentCatalog().getAcroForm();

        if (acroForm != null)
        {

           PDTextField field = (PDTextField) acroForm.getField( "sampleField" );
           field.setValue("Text Entry");
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        pdfDocument.save(baos);
        byte[] pdfBytes = baos.toByteArray(); // PDF Bytes
    }
}