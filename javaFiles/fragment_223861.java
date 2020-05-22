cardBack = new Image(new FileInputStream("images/b1fv.gif"));
// some stuff
for (int i = 0; i < cardImages.length; i++) {
    stackPane[i] = new StackPane();
    stackPane[i].getChildren().addAll(new ImageView(cardBack) , cardImages[i]);
    // rest of the loop
}