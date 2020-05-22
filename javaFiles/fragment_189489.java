PdfReader pdfReader = new PdfReader(INPUT_PDF);
PdfStamper pdfStamper = new PdfStamper(pdfReader, RESULT_STREAM, (char)0, true);

OcspClient ocsp = new OcspClientBouncyCastle();
CrlClient crl = new CrlClientOnline();
makeLtvEnabledV2(pdfStamper, ocsp, crl);

pdfStamper.close();