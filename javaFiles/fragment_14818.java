PdfContentByte cb = writer.getDirectContent();
Image img = createBarcode(cb, "This is a 2D barcode", 1, 1);
document.add(new Paragraph(
    String.format("This barcode measures %s by %s user units",
       img.getScaledWidth(), img.getScaledHeight())));
document.add(img);
img = createBarcode(cb, "This is NOT a raster image", 3, 3);
document.add(new Paragraph(
    String.format("This barcode measures %s by %s user units",
        img.getScaledWidth(), img.getScaledHeight())));
document.add(img);
img = createBarcode(cb, "This is vector data drawn on a PDF page", 1, 3);
document.add(new Paragraph(
    String.format("This barcode measures %s by %s user units",
        img.getScaledWidth(), img.getScaledHeight())));