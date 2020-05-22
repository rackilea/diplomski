public class ScalableImage extends Composite implements MouseWheelHandler, MouseDownHandler, MouseMoveHandler, MouseUpHandler {

    Canvas canvas = Canvas.createIfSupported();
    Context2d context = canvas.getContext2d();

    Canvas backCanvas = Canvas.createIfSupported();
    Context2d backContext = backCanvas.getContext2d();

    int width;
    int height;
    Image image;
    ImageElement imageElement; 

    double zoom = 1;
    double totalZoom = 1;
    double offsetX = 0;
    double offsetY = 0;

    boolean mouseDown = false;
    double mouseDownXPos = 0;
    double mouseDownYPos = 0;


    public ScalableImage(Image image) {
        initWidget(canvas);

        //width = Window.getClientWidth() - 50;

        width = image.getWidth() + 200;
        height = image.getHeight() + 200;


        //canvas.setWidth(width + "px");
        //canvas.setHeight(height + "px");
        canvas.setCoordinateSpaceWidth(width);
        canvas.setCoordinateSpaceHeight(height);

        //backCanvas.setWidth(width + "px");
        //backCanvas.setHeight(height + "px");
        backCanvas.setCoordinateSpaceWidth(width);
        backCanvas.setCoordinateSpaceHeight(height);

        canvas.addMouseWheelHandler(this);
        canvas.addMouseMoveHandler(this);
        canvas.addMouseDownHandler(this);
        canvas.addMouseUpHandler(this);

        this.image = image;
        this.imageElement = (ImageElement) image.getElement().cast();

        mainDraw();
    }

    public void onMouseWheel(MouseWheelEvent event) {
        int move = event.getDeltaY();

        double xPos = (event.getRelativeX(canvas.getElement()));
        double yPos = (event.getRelativeY(canvas.getElement()));

        if (move < 0) {
            zoom = 1.1;
        } else {
            zoom = 1 / 1.1;
        }

        double newX = (xPos - offsetX) / totalZoom;
        double newY = (yPos - offsetY) / totalZoom;

        double xPosition = (-newX * zoom) + newX;
        double yPosition = (-newY * zoom) + newY;

        backContext.clearRect(0, 0, width, height);

        backContext.translate(xPosition, yPosition);

        backContext.scale(zoom, zoom);

        mainDraw();

        offsetX += (xPosition * totalZoom);
        offsetY += (yPosition * totalZoom);

        totalZoom = totalZoom * zoom;

        buffer(backContext, context);
    }

    public void onMouseDown(MouseDownEvent event) {
        this.mouseDown = true;
        mouseDownXPos = event.getRelativeX(image.getElement());
        mouseDownYPos = event.getRelativeY(image.getElement());
    }

    public void onMouseMove(MouseMoveEvent event) {
        if (mouseDown) {
            backContext.setFillStyle("white");
            backContext.fillRect(-5, -5, width + 5, height + 5);
            backContext.setFillStyle("black");
            double xPos = event.getRelativeX(image.getElement());
            double yPos = event.getRelativeY(image.getElement());
            backContext.translate((xPos - mouseDownXPos) / totalZoom, (yPos - mouseDownYPos) / totalZoom);

            offsetX += (xPos - mouseDownXPos);
            offsetY += (yPos - mouseDownYPos);

            mainDraw();
            mouseDownXPos = xPos;
            mouseDownYPos = yPos;
        }
    }

    public void onMouseUp(MouseUpEvent event) {
        this.mouseDown = false;
    }

    public void mainDraw() {
        backContext.drawImage(imageElement, 100, 100);

        buffer(backContext, context);
    }

    public void buffer(Context2d back, Context2d front) {
        front.beginPath();
        front.clearRect(0, 0, width, height);
        front.drawImage(back.getCanvas(), 0, 0);
    }
}