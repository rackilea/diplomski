public class RootLayoutController {

    private Model model ;

    public void initModel(Model model) {
        this.model = model ;
    }

    // handler that adds a point:
    @FXML
    private void addPoint(MouseEvent e) {
        Point p = new Point(e.getX(), e.getY());
        model.getPoints().add(p);
    }
}