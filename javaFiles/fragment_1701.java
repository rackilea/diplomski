Transformer<V, Paint> vertexPaintRed = new Transformer<V, Paint>() {
    public Paint transform(V input) {
         if (jungGraph.inDegree(input) == 0) return Color.RED;
         if (jungGraph.outDegree(input) == 0) return Color.GREEN;
         return Color.BLUE;
    }
};