public class Main extends Application {

final Rectangle rectBound = new Rectangle(0, 0);
Random ran = new Random();

 @Override
 public void start(Stage primaryStage) {
 try {
     rectBound.setFill(Color.TRANSPARENT);
     rectBound.setStroke(Color.GOLD);
     ScrollPane scp = new ScrollPane();
     HBox root = new HBox(15);
     scp.setContent(root);
     //root.setOrientation(Orientation.HORIZONTAL);

     Pane imageViewParent = new Pane();
     imageViewParent.setStyle("-fx-border-color: black; -fx-border-width: 2;");

     ImageView imageView1 = new ImageView(new Image(getUrl(),true));
     imageView1.setLayoutX(0.0);imageView1.setLayoutY(0.0);
     imageViewParent.getChildren().add(imageView1);

     ///////////////////////////////////////////////
     imageViewParent.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
        @Override
            public void handle(MouseEvent event) {

                if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    if (rectBound.getParent() == null) {
                        rectBound.setWidth(0.0); rectBound.setHeight(0.0);
                        rectBound.setLayoutX(event.getX()); rectBound.setLayoutY(event.getY()); // setX or setY
                        imageViewParent.getChildren().add(rectBound);
                    }
                } else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {

                } else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                    rectBound.setWidth(event.getX() - rectBound.getLayoutX());
                    rectBound.setHeight(event.getY() - rectBound.getLayoutY());
                } else if (event.getEventType() == MouseEvent.MOUSE_CLICKED
                        && event.getButton() == MouseButton.SECONDARY) {
                    if (rectBound.getParent() != null) {
                        imageViewParent.getChildren().remove(rectBound);
                    }
                } else if (event.getEventType() == MouseEvent.MOUSE_CLICKED
                        && event.getButton() == MouseButton.PRIMARY && event.getClickCount() > 1) {
                    //////////////// i crop here //////////////
                    PixelReader reader = imageView1.getImage().getPixelReader();
                    WritableImage newImage = new WritableImage(reader, (int) rectBound.getLayoutX(),
                            (int) rectBound.getLayoutY(),
                            (int) rectBound.getWidth(),
                            (int) rectBound.getHeight());

                    root.getChildren().add(new ImageView(newImage));
                }

            }
    });
     //////////////////////////////////////////////
     root.getChildren().add(imageViewParent);

     Scene scene = new Scene(scp,900,650);
     primaryStage.setScene(scene);
     primaryStage.show();
    } catch(Exception e) {
        e.printStackTrace();
    }
}

private String getUrl() {
    switch (ran.nextInt(4)) {
    case 1:
        return "http://6544-presscdn-0-22.pagely.netdna-cdn.com/wp-content/uploads/2013/06/Juliet-Ibrahim2.jpg";

    case 4:
        return "http://6544-presscdn-0-22.pagely.netdna-cdn.com/wp-content/uploads/2016/02/Nadia-Buari.jpg";

    case 2:
        return "http://www.eonlineghana.com/wp-content/uploads/2016/03/1.jpg";

    case 3:
        return "http://fashionpoliceng.com/wp-content/uploads/2015/08/Juliet-Ibrahim-527x600.jpg";

    default:
        return "http://6544-presscdn-0-22.pagely.netdna-cdn.com/wp-content/uploads/2014/04/Juliet-Ibrahim-Foundation-1.jpg";
    }
}

public static void main(String[] args) {
    launch(args);
}
}