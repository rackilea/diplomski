default Stream<T> getAncestors() {
    Stream.Builder<T> parentsBuilder = Stream.builder();
    for(T node = myself(); node != null; node = node.getParent()) {
        parentsBuilder.add(parent);
    }
    return parentsBuilder.build();
}