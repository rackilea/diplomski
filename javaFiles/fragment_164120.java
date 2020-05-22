for(int i = 0; i < 12; i++){
    Label label = new Label(String.valueOf(i==0?12:i));
    Circle c=new Circle(1);

    c.getTransforms().add(new Rotate((i) * (360d / 12d)));
    c.getTransforms().add(new Translate(0,-100d));
    label.setTranslateX(c.localToParent(0,0).getX());
    label.setTranslateY(c.localToParent(0,0).getY());

    StackPane sp = new StackPane(c,label);
    numbers.getChildren().add(sp);
}