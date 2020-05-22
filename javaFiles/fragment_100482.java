private Transformer<String, Paint> edgePaint = new Transformer<String, Paint>() {
    public Paint transform(String s) {
        return Color.RED;
    }
};

private Transformer<String, Stroke> edgeStroke = new Transformer<String, Stroke>() {
    float dash[] = { 10.0f };
    public Stroke transform(String s) {
        return new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
    }
};

(...)

vv.getRenderContext().setEdgeDrawPaintTransformer(edgePaint);
vv.getRenderContext().setEdgeStrokeTransformer(edgeStroke);