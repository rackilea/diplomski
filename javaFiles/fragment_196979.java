Text text1 = new Text("test1");
text1.setLayoutX(11);
text1.setLayoutY(11);

Text text2 = new Text("test2");
AnchorPane.setRightAnchor(text2, 0d);
AnchorPane.setTopAnchor(text2, 0d);

root = new AnchorPane(text1, text2);