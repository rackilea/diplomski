Slider slider = new Slider(0,100,50);
slider.setLayoutY(5);

Line line = new line();
line.setStrokeWidth(2);
line.setStroke(Color.RED);
line.setOpacity(0.3);
line.setStartX(50);
line.setEndX(50);
line.setStartY(4);
line.setEndY(21);
line.setVisible(true);

Group group = new Group(slider, line);