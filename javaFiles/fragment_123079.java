Set<Node> nodes = lineChart.lookupAll(".series" + 0);
for (Node n : nodes) {
    n.setStyle("-fx-background-color: black, white;\n"
            + "    -fx-background-insets: 0, 2;\n"
            + "    -fx-background-radius: 5px;\n"
            + "    -fx-padding: 5px;");
}