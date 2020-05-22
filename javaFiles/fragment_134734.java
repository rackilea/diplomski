byte[] addWatermark(byte[] generatedBytes) {
    try (ByteArrayOutputStream target  = new ByteArrayOutputStream()) {
        PdfReader reader = new PdfReader(generatedBytes);
        PdfStamper stamper = new PdfStamper(reader, target);
        [... add watermark to all pages in stamper ...]
        stamper.close();
        reader.close();
        return target.toByteArray();
    }
}