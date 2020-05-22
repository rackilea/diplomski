private void setUpAppearance(BasicVisualizationServer<Vertex, Edge> vis) {
    vis.setBackground(BGCOLOR);
    vis.setPreferredSize(new Dimension(1500, 600)); // Sets the viewing area

    // modify vertices
    vis.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
    vis.getRenderContext().setVertexFontTransformer(Transformers.vertexFontTransformer);
    vis.getRenderContext().setVertexShapeTransformer(Transformers.vertexShapeTransformer);
    vis.getRenderContext().setVertexFillPaintTransformer(Transformers.vertexFillPaintTransformer);
    vis.getRenderContext().setVertexDrawPaintTransformer(Transformers.vertexDrawPaintTransformer);
    vis.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);

    // modify edges
    vis.getRenderContext().setEdgeShapeTransformer(Transformers.edgeShapeTransformer);
    vis.getRenderContext().setEdgeDrawPaintTransformer(Transformers.edgeDrawPaintTransformer);
    vis.getRenderContext().setArrowDrawPaintTransformer(Transformers.edgeDrawPaintTransformer);
    vis.getRenderContext().setArrowFillPaintTransformer(Transformers.edgeDrawPaintTransformer);
    vis.getRenderContext().setEdgeArrowPredicate(Transformers.edgeArrowPredicate);
    vis.getRenderContext().setEdgeStrokeTransformer(Transformers.edgeStrokeHighlightingTransformer);
}