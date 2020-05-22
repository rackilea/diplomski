public class MazeController {

    @FXML
    private Canvas canvas ;

    @FXML
    private void doKrushkal(ActionEvent e) {
        KrushkalA kruAlg = new KrushkalA();
        List<Boundary> maze = kruAlg.drawMaze();
        // now render maze on canvas, using data in the List<Boundary> from above
        renderMaze(maze);
    }

    private void renderMaze(List<Boundary> maze) {
        // clear canvas, iterate through boundaries in maze,
        // and draw lines in appropriate place, etc.
    }
}