public class CerchioListener implements EventHandler<ActionEvent> {

    private Canvas canvas = null;
    public ObjectProperty<Color> colorProperty = new SimpleObjectProperty<Color>(Color.WHITE);

    public CerchioListener(Canvas c) {
        this.canvas = c;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void handle(ActionEvent t) {
        canvas.getGraphicsContext2D().setFill(colorProperty.get());
        canvas.getGraphicsContext2D().fillOval(20, 20, 20, 20);
    }

}