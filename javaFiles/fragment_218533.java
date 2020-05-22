void extractHashes(PdfReader reader) throws Exception
{
    AcroFields acroFields = reader.getAcroFields();
    List<String> names = acroFields.getSignatureNames();

    for (String name: names)
    {
        PdfPKCS7 pdfPkcs7 = acroFields.verifySignature(name);
        pdfPkcs7.verify();

        Field digestAttrField = PdfPKCS7.class.getDeclaredField("digestAttr");
        digestAttrField.setAccessible(true);
        byte[] digestAttr = (byte[]) digestAttrField.get(pdfPkcs7);

        // process the digest value in digestAttr 
    }
}