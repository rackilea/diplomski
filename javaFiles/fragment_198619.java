import javafx.geometry.Point2D;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

// ...

private Point2D lastErasePoint;

// ...

    canvas.setOnMousePressed(mouseEvent -> {
        if (drawButton.isSelected() && !eraseButton.isSelected()) {
            gc.beginPath();
            gc.lineTo(mouseEvent.getSceneX(), mouseEvent.getSceneY() - mouseOffset);
            gc.stroke();
        } else if (!drawButton.isSelected() && eraseButton.isSelected()) {
            lastErasePoint = new Point2D(
                mouseEvent.getSceneX(), mouseEvent.getSceneY() - mouseOffset);
        }
    });

    canvas.setOnMouseDragged(mouseEvent -> {
        if (drawButton.isSelected() && !eraseButton.isSelected()) {
            gc.lineTo(mouseEvent.getSceneX(), mouseEvent.getSceneY() - mouseOffset);
            gc.stroke();
        } else if (!drawButton.isSelected() && eraseButton.isSelected()) {
            Point2D location = new Point2D(
                mouseEvent.getSceneX(), mouseEvent.getSceneY() - mouseOffset);

            Point2D diff = location.subtract(lastErasePoint);
            double angle = Math.toDegrees(
                Math.atan2(diff.getY(), diff.getX()));
            double width = gc.getLineWidth();

            gc.save();
            gc.setTransform(new Affine(new Rotate(
                angle, lastErasePoint.getX(), lastErasePoint.getY())));
            gc.clearRect(
                lastErasePoint.getX() - width / 2,
                lastErasePoint.getY() - width / 2,
                lastErasePoint.distance(location) + width, width);
            gc.restore();

            lastErasePoint = location;
        }
    });