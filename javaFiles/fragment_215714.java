public PdfPKCS7 verifySignature(AcroFields fields, String name) throws GeneralSecurityException, IOException {
    System.out.println("Signature covers whole document: " + fields.signatureCoversWholeDocument(name));
    System.out.println("Document revision: " + fields.getRevision(name) + " of " + fields.getTotalRevisions());
    PdfPKCS7 pkcs7 = fields.verifySignature(name);
    System.out.println("Integrity check OK? " + pkcs7.verify());
    return pkcs7;
}

public void verifySignatures(String path) throws IOException, GeneralSecurityException {
    System.out.println(path);
    PdfReader reader = new PdfReader(path);
    AcroFields fields = reader.getAcroFields();
    ArrayList<String> names = fields.getSignatureNames();
    for (String name : names) {
        System.out.println("===== " + name + " =====");
        verifySignature(fields, name);
    }
    System.out.println();
}