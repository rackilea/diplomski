...
if (ocsp.size() > 0)
    vri.put(PdfName.OCSP, writer.addToBody(ocsp, false).getIndirectReference());
if (crl.size() > 0)
    vri.put(PdfName.CRL, writer.addToBody(crl, false).getIndirectReference());
if (cert.size() > 0)
    vri.put(PdfName.CERT, writer.addToBody(cert, false).getIndirectReference());
// v--- added line
vri.put(PdfName.TU, new PdfDate());
// ^--- added line
vrim.put(vkey, writer.addToBody(vri, false).getIndirectReference());
...