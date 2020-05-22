private final ChangeListener<Number> checkIntersection = (ob,n,n1)->{
    if (iv_plane.getBoundsInParent().intersects(iv_ship.getBoundsInParent())){
        System.out.println("Intersection detected");
    }
};

private ImageView iv_ship, iv_plane;

private void drawGame (Stage primaryStage) {
    iv_ship = new ImageView();
    iv_plane = new ImageView();
    ...
    iv_ship.translateXProperty().addListener(checkIntersection);
    iv_ship.translateYProperty().addListener(checkIntersection);
    ...
    root.getChildren().addAll(iv_plane,iv_ship);
    primaryStage.setScene(scene_game);
}