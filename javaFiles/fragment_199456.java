private void setNode(Node node) {
    AnchorPane.setBottomAnchor(node, 0);
    AnchorPane.setTopAnchor(node, 0);
    AnchorPane.setLeftAnchor(node, 0);
    AnchorPane.setRightAnchor(node, 0);

    holderPane.getChildren().setAll(node);
}