public class Dijkstra<V, E> {

    private final ToDoubleFunction<E> edgeToWeightFunction;

    public Dijkstra(ToDoubleFunction<E> edgeToWeightFunction) {
        this.edgeToWeightFunction = edgeToWeightFunction;
    }

    private double getEdgeWeight(E edge) {
         return edgeToWeightFunction.applyAsDouble(edge);
    }
    ...
}