private ToggleButton myButton = new ToggleButton("Place Archer");

// ...

scene.setOnMouseClicked(e -> {
    if (myButton.isSelected()) {
         archer.setX((int)e.getSceneX());
         archer.setY((int)e.getSceneY());
         archer.drawCharStand(gc);
         myButton.setSelected(false);
    }
});