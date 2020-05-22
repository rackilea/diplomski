scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
  @Override
  public void handle(KeyEvent event){

    if (event.getCode() == KeyCode.RIGHT) {
        cImage.setLayoutX(cImage.getLayoutX() + 10);
    } else if (event.getCode() == KeyCode.LEFT) {
        cImage.setLayoutX(cImage.getLayoutX() - 10);
    }
  }
});