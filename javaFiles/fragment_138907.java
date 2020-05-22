EdgeProvider<V, E> ep = new EdgeProvider<V, E>() {
    @Override
    public E buildEdge(V from, V to, String label, Map<String, String> attributes) {
        return eCons.get();
    }
};