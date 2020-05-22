class Graph<E> {
    private List<Vertex<E>> vertices;

    private static class Vertex<E> {
        E elem;
        List<Vertex<E>> neighbors;
    }
}