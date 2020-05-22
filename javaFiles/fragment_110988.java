Transformer<Integer, Paint> vertexPaint = new Transformer<Integer, Paint>() {
    public Paint transform(Integer i) {
        if (i == wantedVertex) {
            return Color.WHITE; // Example of color from java.awt.Color
        }
        else {
            return Color.BLACK;
        }
    }
};

viz.getRenderContext().setVertexFillPaintTransformer(vertexPaint);