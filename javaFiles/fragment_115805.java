private final Tooltip errorTip = new Tooltip();

// ...

private void ValidateRequired(TextField field){
    if(field.getText().equals("")){
        field.getStyleClass().add("errorField");
        errorTip.setText("This is required");
        errorTip.getStyleClass().removeAll();
        Scene scene = field.getScene();
        scene.getStylesheets().add(this.getClass().getResource("../css/sale.css").toExternalForm());
        errorTip.getStyleClass().add("errorTip");
        Point2D p = field.localToScene(0.0, 0.0);
        errorTip.show(field,p.getX()
                + field.getScene().getX() + field.getScene().getWindow().getX(), p.getY()
                + field.getScene().getY() + field.getScene().getWindow().getY()+field.getHeight()+2);


    }
    else{
        errorTip.setText("");
        errorTip.hide();
    }
}