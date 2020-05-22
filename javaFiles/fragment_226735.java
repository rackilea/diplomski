protected Node impl_pickNodeLocal(double localX, double localY) {
    if (containsBounds(localX, localY)) {
        ObservableList<Node> children = getChildren();
        for (int i = children.size()-1; i >= 0; i--) {
            Node picked = children.get(i).impl_pickNode(localX, localY);
            if (picked != null) return picked;
        }
        // hack to make pane itself transparent for mouse
        // if (contains(localX, localY)) return this;
    }
    return null;
}