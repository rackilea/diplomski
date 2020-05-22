void addLtvNoTS(InputStream src, OutputStream dest, IOcspClient ocsp, ICrlClient crl, LtvVerification.Level timestampLevel, LtvVerification.Level signatureLevel) throws IOException, GeneralSecurityException 
{
    PdfDocument pdfDoc = new PdfDocument(new PdfReader(src), new PdfWriter(dest), new StampingProperties().useAppendMode());

    LtvVerification v = new LtvVerification(pdfDoc);
    SignatureUtil signatureUtil = new SignatureUtil(pdfDoc);

    List<String> names = signatureUtil.getSignatureNames();
    String sigName = names.get(names.size() - 1);

    PdfPKCS7 pkcs7 = signatureUtil.verifySignature(sigName);

    if (pkcs7.isTsp())
    {
        v.addVerification(sigName, ocsp, crl, LtvVerification.CertificateOption.WHOLE_CHAIN,
                timestampLevel, LtvVerification.CertificateInclusion.YES);
    }
    else
    {
        for (String name : names)
        {
            v.addVerification(name, ocsp, crl, LtvVerification.CertificateOption.WHOLE_CHAIN,
                    signatureLevel, LtvVerification.CertificateInclusion.YES);
        }
    }

    v.merge();
    pdfDoc.close();
}