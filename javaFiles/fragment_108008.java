package sample;

import ...

import java.io.IOException;

public class Controller {
    @FXML
    AnchorPane anchorPane;

    public void add() {
        try {
            // Node.fxml is the custom node object
            Parent root = FXMLLoader.load(getClass().getResource("Node.fxml"));
            // Sets the EventHandlers for dragging
            dragNode(root);
            // Adds the node to the scene
            anchorPane.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Handles all dragging EventHandlers for any node object
    public void dragNode(Node node) {
        // Custom object to hold x and y positions
        final Delta dragDelta = new Delta();

        node.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                dragDelta.x = node.getLayoutX() - mouseEvent.getSceneX();
                dragDelta.y = node.getLayoutY() - mouseEvent.getSceneY();
            }
        });

        node.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                node.setCursor(Cursor.HAND);
            }
        });

        node.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                node.setLayoutX(mouseEvent.getSceneX() + dragDelta.x);
                node.setLayoutY(mouseEvent.getSceneY() + dragDelta.y);
            }
        });

        node.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                node.setCursor(Cursor.HAND);
            }
        });
    }

    class Delta { double x, y; }
}