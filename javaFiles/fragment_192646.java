/**
 * Constructs a PdfSignatureAppearance object.
 * @param writer    the writer to which the signature will be written.
 */
PdfSignatureAppearance(PdfStamperImp writer) {
    [...]
    signDate = new GregorianCalendar();
    [...]
}