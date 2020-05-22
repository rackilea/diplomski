private Optional<Node> findNode(Pane pane, double x, double y) {
    return pane.getChildren().stream().filter(n -> {
      Point2D point = n.sceneToLocal(x, y);
      return n.contains(point.getX(), point.getY());
    }).findAny();
  }