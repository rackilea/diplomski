// The @FXML annotation is removed!
public void moveUp() {       
    cannone_im.sceneProperty().addListener(new ChangeListener<Scene>() {

        @Override
        public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {

            if(newValue != null){
                cannone_im.getScene().setOnKeyPressed((KeyEvent ke) -> {
                    if (ke.getCode().equals(KeyCode.RIGHT)) {
                        rt = new RotateTransition(Duration.millis(100), cannone_im);
                        if (cannone_im.getRotate() > -70) {
                            rt.setAxis(Z_AXIS);                    
                            rt.setByAngle(cannone_im.getRotate());
                             rt.setToAngle(cannone_im.getRotate() - 5);
                        } else {                    
                            rt.setToAngle(-70);
                        }
                    }
                    rt.play();
                });
            }
        }
    });
}