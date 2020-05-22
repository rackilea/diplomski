Rectangle rect = new Rectangle(100, 200);
rect.setLayoutX(11);
rect.setLayoutY(33);
rect.setScaleX(2);

Pane root = new Pane();
root.getChildren().add(rect);
System.out.println(rect.getBoundsInLocal());
System.out.println(rect.getBoundsInParent());