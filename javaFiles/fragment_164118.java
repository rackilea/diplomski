Group numbers = new Group();
for(int i = 0; i < 12; i++){
    //create a label.
    Label label = new Label(String.valueOf(i==0?12:i));
    label.getTransforms().add(new Rotate(i * (360d / 12d)));
    label.getTransforms().add(new Translate(100d,100d));

    numbers.getChildren().add(label);
}