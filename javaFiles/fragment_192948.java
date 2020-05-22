public class DrawerContentController implements Initializable {

    private final DoubleProperty progress = new SimpleDoubleProperty();

    public DoubleProperty progressProperty() {
        return progress ;
    }

    public final double getProgress() {
        return progressProperty().get();
    }

    public final void setProgress(double progress) {
        progressProperty().set(progress);
    }

    // existing code...

}