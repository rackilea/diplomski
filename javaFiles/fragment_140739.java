for(int i = 0; i < 3 ; i++){
    Rectangle r = new Rectangle(100.0, 10.0, Color.BLACK);
    rectangles.add(r);
    vbox.getChildren().add(r);
    vbox.layout();

    System.out.println(" r Yposition :" + r.getLayoutY() + " or " + r.getBoundsInParent().getMinY() + " or " + r.getBoundsInLocal().getMinY());
    System.out.println("Vbox height : " + vbox.getBoundsInLocal().getHeight());
}