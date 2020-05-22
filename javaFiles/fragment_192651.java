public class SelectionBoxDemo extends Application {

public static void main(String[] args) {
    launch(args);
}

@Override
public void start(Stage arg0) throws Exception {
    Stage stage = new Stage ();

    // Root is the base pane in which we put everything
    Pane root = new Pane ();

    SelectionBox sb = new SelectionBox ();

    sb.setSize(100, 100);

    root.getChildren().add(sb);

    // Create a new scene
    Scene scene = new Scene (root);

    stage.setScene(scene);

    stage.setMinHeight(500);
    stage.setMinWidth(500);

    stage.show();
}

public static class SelectionBox extends Region {

    private enum Position {
        TopLeft, Top, TopRight, Right, BottomRight, Bottom, BottomLeft, Left; 
    }

    // Create the corners
    private Rectangle tr, tl, br, bl;

    // Create selection lines
    final private Line top, right, bottom, left;

    // Size of corner boxes
    private double cornerSize = 10;

    // Create a new rotate transform
    private final Rotate rotate = new Rotate();
    {
        getTransforms().add(rotate);
        rotate.setPivotX(cornerSize);
        rotate.setPivotY(cornerSize);
    }

    // Circle which is dragged to rotate the box
    private final Circle rotateCircle;

    // Variables to store mouse x and y
    private double x, y;

    public SelectionBox () {

        // Create the circle which can be dragged to rotate the box
        rotateCircle = new Circle(5);
        rotateCircle.setFill(Color.PINK);
        rotateCircle.setStroke(Color.rgb(0,0,0, 0.75));

        // Make it draggable
        rotateCircle.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                setMouse(event.getSceneX(), event.getSceneY());
            }
        });

        // When it's dragged rotate the box
        rotateCircle.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {

                // Used to get the scene position of the corner of the box
                Transform localToScene = getLocalToSceneTransform();

                double x1 = getMouseX();
                double y1 = getMouseY();

                double x2 = event.getSceneX();
                double y2 = event.getSceneY();

                double px = rotate.getPivotX() + localToScene.getTx();
                double py = rotate.getPivotY() + localToScene.getTy();

                // Work out the angle rotated
                double th1 = clockAngle(x1, y1, px, py);
                double th2 = clockAngle(x2, y2, px, py);

                double angle = rotate.getAngle();

                angle += th2 - th1;

                // Rotate the rectangle
                rotate.setAngle(angle);

                setMouse(event.getSceneX(), event.getSceneY());
            }
        });

        // Build the corners
        tr = buildCorner (0,0, Position.TopRight);
        tl = buildCorner (0,0, Position.TopLeft);
        br = buildCorner (0,0, Position.BottomRight);
        bl = buildCorner (0,0, Position.BottomLeft);

        // Build the lines
        top = buildLine(0, 100, -100, 0);
        bottom = buildLine(0, 0, 0, 0);
        left = buildLine(0, 0, 0, 0);
        right = buildLine(0, 0, 0, 0);

        getChildren().addAll(top, bottom, left, right, tr, tl, br, bl, rotateCircle);

    }

    // Return the angle from 0 - 360 degrees
    public double clockAngle (double x, double y, double px, double py) {
        double dx = x - px;
        double dy = y - py;

        double angle = Math.abs(Math.toDegrees(Math.atan2(dy, dx)));

        if(dy < 0) {
            angle = 360 - angle;
        }

        return angle;
    }

    // Set the size of the selection box
    public void setSize (double width, double height) {
        tl.setX(0);
        tl.setY(0);

        tr.setX(width + cornerSize);
        tr.setY(0);

        bl.setX(0);
        bl.setY(height + cornerSize);

        br.setX(width + cornerSize);
        br.setY(height + cornerSize);

        setLine(top, cornerSize, cornerSize, width + cornerSize, cornerSize);
        setLine(bottom, cornerSize, height + cornerSize, width + cornerSize, height + cornerSize);
        setLine(right, width + cornerSize, cornerSize, width + cornerSize, height + cornerSize);
        setLine(left, cornerSize, cornerSize, cornerSize, height + cornerSize);

        top.setCursor(Cursor.V_RESIZE);
        bottom.setCursor(Cursor.V_RESIZE);
        left.setCursor(Cursor.H_RESIZE);
        right.setCursor(Cursor.H_RESIZE);

        tr.setCursor(Cursor.CROSSHAIR);
        tl.setCursor(Cursor.CROSSHAIR);
        br.setCursor(Cursor.CROSSHAIR);
        bl.setCursor(Cursor.CROSSHAIR);

        rotateCircle.setTranslateX(width + 2 * cornerSize + rotateCircle.getRadius());
        rotateCircle.setTranslateY(height + 2 * cornerSize + rotateCircle.getRadius());

    }

    // Set the start and end points of a line
    private void setLine (Line l, double x1, double y1, double x2, double y2) {
        l.setStartX(x1);
        l.setStartY(y1);
        l.setEndX(x2);
        l.setEndY(y2);
    }

    // Save mouse coordinates
    private void setMouse(double x, double y) {
        this.x = x;
        this.y = y;
    }

    private double getMouseX () {
        return x;
    }

    private double getMouseY () {
        return y;
    }

    // Selection box width
    public double w () {
        return Math.abs(bottom.getEndX() - bottom.getStartX());
    }

    // Selection box height
    public double h () {
        return Math.abs(right.getEndY() - right.getStartY());
    }

    // Build a corner of the rectangle
    private Rectangle buildCorner (double x, double y, final Position pos) {

        // Create the rectangle
        Rectangle r = new Rectangle();
        r.setX(x);
        r.setY(y);
        r.setWidth(cornerSize);
        r.setHeight(cornerSize);
        r.setStroke(Color.rgb(0,0,0,0.75));
        r.setFill(Color.rgb(0, 0, 0, 0.25));
        r.setStrokeWidth(1);

        r.setStrokeType(StrokeType.INSIDE);


        // Make it draggable
        r.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                setMouse(event.getSceneX(), event.getSceneY());
            }
        });

        r.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {

                // Get the mouse deltas
                double dx = event.getSceneX() - getMouseX();
                double dy = event.getSceneY() - getMouseY();

                // Set save the current mouse value
                setMouse(event.getSceneX(), event.getSceneY());

                // Get the rotation angle in radians
                double tau = - Math.toRadians(rotate.getAngle());

                // Create variables for the sin and cosine
                double sinTau = Math.sin(tau);
                double cosTau = Math.cos(tau);

                // Perform a rotation on dx and dy to the object co-ordinate frame
                double dx_ = dx * cosTau - dy * sinTau;
                double dy_ = dy * cosTau + dx * sinTau;

                // Create a variable for the change in height of the box
                double dh = h();

                // Work out the new positions for the resize corners
                if(pos == Position.TopLeft) {
                    // Set the size based on the transformed dx and dy values
                    setSize(w() - dx_, h() - dy_);

                    // Move the shape 
                    setTranslateX(getTranslateX() + dx); 
                    setTranslateY(getTranslateY() + dy);
                }
                else if (pos == Position.TopRight) {

                    // This comes down to geometry - you need to know the 
                    // amount the height of the shape has increased
                    setSize(w() + dx_ , h() - dy_);

                    // Work out the delta height - that is then used to work out 
                    // the correct translations
                    dh = h() - dh;

                    setTranslateX (getTranslateX() - dh * sinTau);
                    setTranslateY (getTranslateY() - dh * cosTau);
                }
                else if (pos == Position.BottomRight) {
                    setSize(w() + dx_ , h() + dy_ );
                }
                else if (pos == Position.BottomLeft) {

                    setSize(w() - dx_, h() + dy_);

                    dh = h() - dh;

                    setTranslateX(getTranslateX() + dx - dh * sinTau );
                    setTranslateY(getTranslateY() + dy - dh * cosTau);
                }
            }
        });


        return r;
    }



    private Line buildLine (double x1, double y1, double x2, double y2) {
        Line l = new Line (x1, y1, x2, y2);

        l.setStroke(Color.rgb(0, 0, 0, 0.75));
        l.setStrokeWidth (0.5);

        return l;
    }


}