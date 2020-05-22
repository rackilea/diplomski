Collection<Vector> vectors = nodeToVectorMapping.get(node);
if (vectors == null) {
    vectors = new HashSet<Vector>();
    nodeToVectorMapping.put(node, vectors);
}
vectors.add(vector);