public class Controller {

    public SplitPane splitPane;
    public TreeTableView treeTable;
    public AnchorPane anchorPane;


    public void setStartingPosition(Stage stage){
        stage.addEventHandler(WindowEvent.WINDOW_SHOWN, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                double tableWidth = treeTable.getWidth();
                double stageWidth = stage.getWidth();
                splitPane.setDividerPositions(tableWidth / stageWidth);
            }
        });
    }
}