Text t1 = new Text(Character.toString('O'));
t1.setFont(Font.font ("Verdana", 20));
t1.setFill(Color.RED);
Text t2 = new Text(Character.toString('x'));
t2.setFont(Font.font ("Verdana", 12));
t1.setFill(Color.BLUE);
StackPane sp = new StackPane(t1, t2);
Button button = new Button("", sp);