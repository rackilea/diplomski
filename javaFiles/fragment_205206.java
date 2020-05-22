static BridgeContext ctx = new BridgeContext(new UserAgentAdapter());
static GVTBuilder builder = new GVTBuilder();

private static void calculateSize(SVGDocument doc) {
    GraphicsNode gvtRoot = builder.build(ctx, doc);

    Rectangle2D rect = gvtRoot.getSensitiveBounds();

    doc.getRootElement().setAttributeNS(null,
            SVGConstants.SVG_WIDTH_ATTRIBUTE, rect.getMaxX() + "");
    doc.getRootElement().setAttributeNS(null,
            SVGConstants.SVG_HEIGHT_ATTRIBUTE, rect.getMaxY() + "");
}