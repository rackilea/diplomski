PdfReader pdfReader = new PdfReader(INPUT_PDF);
PdfStamper pdfStamper = new PdfStamper(pdfReader, RESULT_STREAM, (char)0, true);

AdobeLtvEnabling adobeLtvEnabling = new AdobeLtvEnabling(pdfStamper);
OcspClient ocsp = new OcspClientBouncyCastle();
CrlClient crl = new CrlClientOnline();
adobeLtvEnabling.enable(ocsp, crl);

pdfStamper.close();