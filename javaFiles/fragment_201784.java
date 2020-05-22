public class MyPdfPageEvent extends PdfPageEventHelper {
  public void onGenericTag(PdfWriter writer, Document doc, Rectangle rect, String tag) {
      PdfContentByte canvas = writer.getDirectContent();
      canvas.saveState();
      canvas.setColorStroke(Color.BLACK); // or whatever
      // You can also mess with the line's thickness, endcaps, dash style, etc.
      // Lots of options to play with.
      canvas.moveTo(rect.getLeft(), rect.getBottom());
      canvas.lineTo(rect.getRight(), rect.getTop());
      canvas.stroke();
      canvas.restoreState();
  }
}