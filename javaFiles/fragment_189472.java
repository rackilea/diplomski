/**
 * Creates an instance for the specified graph, X distance, and Y distance.
 */
public TreeLayout(Forest<V,E> g, int distx, int disty) {
    if (g == null)
        throw new IllegalArgumentException("Graph must be non-null");
    if (distx < 1 || disty < 1)
        throw new IllegalArgumentException("X and Y distances must each be positive");
    this.graph = g;
    this.distX = distx;
    this.distY = disty;
    buildTree();
}