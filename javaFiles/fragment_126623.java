match.setOnAction((ActionEvent evt) -> {
    Bounds bBounds = bigRec.getBoundsInParent();
    Bounds bounds = r.getBoundsInParent();
    if (bounds.getMinY() <= bBounds.getMaxY() && bounds.getMaxY() >= bBounds.getMinY()) {
        pt.stop();
        pt2.stop();
    }
});