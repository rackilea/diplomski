for (Data<Number, Number> entry : series.getData()) {      
    entry.getNode().setStyle("-fx-background-color: black, white;\n"
        + "    -fx-background-insets: 0, 2;\n"
        + "    -fx-background-radius: 5px;\n"
        + "    -fx-padding: 5px;");
}