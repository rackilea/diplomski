@FXML AnchorPane apMain;

Rectangle rectangle;

@Override
public void initialize(URL url, ResourceBundle rb) {

}

@FXML void handleOnMouseClick(MouseEvent event)
{
    double x = event.getSceneX();
    double y = event.getSceneY();

    rectangle = new Rectangle();
    rectangle.setX(x);
    rectangle.setY(y);
    rectangle.setWidth(25);
    rectangle.setHeight(25);
    apMain.getChildren().add(rectangle);

}

@FXML void handleOnMouseDrag(MouseEvent event)
{

    rectangle.setWidth(event.getSceneX() - x);
    rectangle.setHeight(event.getSceneY() - y);
}

@FXML void handleOnMouseRelease(MouseEvent event)
{
    apMain.getChildren().remove(rectangle);
}