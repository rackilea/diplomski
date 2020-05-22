public class FXMLController implements Initializable {

    @FXML
    private Text textIp;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Task<Void> task = new IpTask(textIp);

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }

    ...
}