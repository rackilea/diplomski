Text text1 = new Text("test1");
StackPane.setMargin(text1, new Insets(11, 0, 0, 11));
StackPane.setAlignment(text1, Pos.TOP_LEFT);

Text text2 = new Text("test2");
StackPane.setAlignment(text2, Pos.TOP_RIGHT);

root = new StackPane(text1, text2);