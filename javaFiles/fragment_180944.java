public class AddAnnotation extends PdfPageEventHelper {
    protected PdfStamper stamper;
    protected AffineTransform transform;

    public AddAnnotation(PdfStamper stamper, AffineTransform transform) {
        this.stamper = stamper;
        this.transform = transform;
    }

    @Override
    public void onGenericTag(PdfWriter writer, Document document, Rectangle rect, String text) {
        float[] pts = {rect.getLeft(), rect.getBottom(), rect.getRight(), rect.getTop()};
        transform.transform(pts, 0, pts, 0, 2);
        float[] dstPts = {pts[0], pts[1], pts[2], pts[3]};
        rect = new Rectangle(dstPts[0], dstPts[1], dstPts[2], dstPts[3]);
        PdfAnnotation annot = PdfAnnotation.createLink(writer, rect, PdfAnnotation.HIGHLIGHT_INVERT, new PdfAction(text));
        stamper.addAnnotation(annot, 1);
    }
}