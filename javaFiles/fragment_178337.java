private Line connect(Line line, Circle startNode, Circle endNode) {
        line.startXProperty().bind(startNode.centerXProperty().add(startNode.translateXProperty()));
        line.startYProperty().bind(startNode.centerYProperty().add(startNode.translateYProperty()));
        line.endXProperty().bind(endNode.centerXProperty().add(endNode.translateXProperty()));
        line.endYProperty().bind(endNode.centerYProperty().add(endNode.translateYProperty()));

    return line;
}