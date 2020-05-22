Transformer<V, Paint> vertexPaintRed = new Transformer<V, Paint>() {
    public Paint transform(V input) {
         if (hasOnlyOutgoingEdges(input)) return Color.RED;
         if (hasOnlyIncomingEdges(input)) return Color.GREEN;
         return Color.BLUE;
    }
};