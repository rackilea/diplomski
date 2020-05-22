Group numbers = new Group();
for(int i = 0; i < 12; i++){
    //create a label.
    Label label = new Label(String.valueOf(i==0?12:i));
    Circle c=new Circle(1);

    c.getTransforms().add(new Rotate(i * (360d / 12d)));
    c.getTransforms().add(new Translate(0,-100));

    label.setTranslateX(c.localToParent(0,0).getX());
    label.setTranslateY(c.localToParent(0,0).getY());

    numbers.getChildren().addAll(c,label);
}