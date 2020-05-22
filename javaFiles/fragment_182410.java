Text text1 = new Text("word 1");
Text text2 = new Text("word 2");
ImageView imageView = new ImageView(
    new Image(getClass().getResource("smile.png").toExternalForm())
);
TextFlow textFlow = new TextFlow(text1, imageView, text2);