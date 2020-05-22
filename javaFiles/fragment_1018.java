private void drawCircle(PDPageContentStream contentStream, int cx, int cy, int r, int red, int green, int blue) throws IOException {
    final float k = 0.552284749831f;
    contentStream.setNonStrokingColor(red, green, blue);
    contentStream.moveTo(cx - r, cy);
    contentStream.curveTo(cx - r, cy + k * r, cx - k * r, cy + r, cx, cy + r);
    contentStream.curveTo(cx + k * r, cy + r, cx + r, cy + k * r, cx + r, cy);
    contentStream.curveTo(cx + r, cy - k * r, cx + k * r, cy - r, cx, cy - r);
    contentStream.curveTo(cx - k * r, cy - r, cx - r, cy - k * r, cx - r, cy);
    contentStream.fill();
}