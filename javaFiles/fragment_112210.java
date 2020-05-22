public class TestautomatView implements Initializable {

    @FXML 
    private ComboBox<String> environmentCombo;

    @FXML 
    private Hyperlink crhl;

    @FXML
    private Hyperlink help;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private Scene scene;
    private BorderPane root;

    public TestautomatView() throws MalformedURLException, IOException {

        FXMLLoader loader = new FXMLLoader(TestautomatView.class.getResource("Sample.fxml"));
        loader.setController(this);
        root = loader.load();

        scene = new Scene(root);
    }

    // etc...

}