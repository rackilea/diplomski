public abstract class ExampleClass implements Initializable {

    public void ExampleClass() {
        // Load FXML
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize stuff
    }

    @PostConstruct
    public void afterInitialize() {
        // Do things that are reliant upon the FXML being loaded
    }
}


public class ExampleSubclass extends ExampleClass {

    public ExampleSubclass() {
        super(/* real code has params */);
    }

    @PostConstruct
    @Override
    public void afterInitialize() {
         super.afterInitialize();
        // other things
    }
}