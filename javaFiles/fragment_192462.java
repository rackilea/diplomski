class View1 extends Group {

    public View1(String imagePath) {

        Image img = new Image(imagePath);
        Canvas canvas = new Canvas(img.getWidth(), img.getHeight());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(img, 0, 0, canvas.getWidth(), canvas.getHeight());
        getChildren().add(canvas);
    }
}