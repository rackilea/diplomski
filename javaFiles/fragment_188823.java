@FXML
public void handleButton() {
    if (mainApp.isPaused()) { // You added a getter for paused
        mainApp.pause();
    }
    else {
        mainApp.resume();
    }
}