Group group = new Group();
Pane pane = new Pane(group);

pane.setPrefWidth(300);
pane.setPrefHeight(300);

group.getChildren().add(new Circle(0, 0, 10));
group.setTranslateX(pane.getPrefWidth() / 2);
group.setTranslateY(pane.getPrefHeight() / 2);