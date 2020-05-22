public class MainController {

    @FXML
    private GridPane root;

    private final List<SubController> subControllers = new ArrayList<>();

    public void setRowNumber(int rows) throws IOException {
        if (rows < subControllers.size()) {
            // for simplicity only allow the number of rows to grow
            throw new IllegalArgumentException();
        }
        for (int i = subControllers.size(); i < rows; i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sub.fxml"));

            // add rowIndex to be used from fxml using $rowIndex
            loader.getNamespace().put("rowIndex", subControllers.size() + 1);

            loader.setRoot(root);
            loader.load();
            subControllers.add(loader.getController());
        }
    }

}