// Open the document
PdfDocument pdfDocument = new PdfDocument(new PdfReader(filePath));

// Parse conformance level from metadata explicitly
byte[] existingXmpMetadata = pdfDocument.getXmpMetadata();
XMPMeta meta = XMPMetaFactory.parseFromBuffer(existingXmpMetadata);
PdfAConformanceLevel conformanceLevel = PdfAConformanceLevel.getConformanceLevel(meta);