public class StartController implements Initializable {

// Some other fields

    @FXML
    private TextArea eventLog;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle ) {
        // other initialize stuff

        // bind the log property to this event log
        // Bindings.bindBidirectional() if you want to be able to control the property from both sides.
        eventLog.textProperty().bind(LogInfo.logDataProperty());

        // ...
    }
}