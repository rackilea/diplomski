[...]
Document document = getDocument();
PdfWriter writer = newWriter(document, baos);

// Apply preferences and build metadata.
prepareWriter(model, writer, request);
buildPdfMetadata(model, document, request);

// Build PDF document.
document.open();
[...]