ZugferdDocument pdfDocument = new ZugferdDocument(
    new PdfWriter(fos), ZugferdConformanceLevel.ZUGFeRDComfort,
    new PdfOutputIntent("Custom", "", "http://www.color.org",
        "sRGB IEC61966-2.1", new FileInputStream(INTENT)));
pdfDocument.addFileAttachment(
    "ZUGFeRD invoice", dom.toXML(), "ZUGFeRD-invoice.xml",
    PdfName.ApplicationXml, new PdfDictionary(), PdfName.Alternative);
pdfDocument.setTagged();

HtmlConverter.convertToPdf(
    new ByteArrayInputStream(html), pdfDocument, getProperties());