import javafx.scene.shape.*;

VBox box = ...;
Rectangle r = new Rectangle();
r.widthProperty().bind(box.widthProperty());
r.heightProperty().bind(box.heightProperty());
r.setArcWidth(10);
r.setArcHeight(10);

box.setClip(r);