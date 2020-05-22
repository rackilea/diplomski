public class JavaApp {
    public void openNewWindow() {
        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("new-window.fxml"));
                Parent root = loader.load();
                Stage newStage = new Stage();
                newStage.setTitle("New window");
                newStage.setScene(new Scene(root, 100, 100));
                newStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}