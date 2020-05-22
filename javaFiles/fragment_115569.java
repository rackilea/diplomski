public class CloseWindowConfirmation implements EventHandler<WindowEvent>() {
    @Override
    public void handle(WindowEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("You are about to exit the game.");
        alert.setContentText("Are you sure?");
        alert.setTitle("Warning");
        alert.getButtonTypes().clear();
        ButtonType no = new ButtonType("No");
        ButtonType yes = new ButtonType("Yes");
        alert.getButtonTypes().addAll(no, yes);
        alert.showAndWait();
        if (alert.getResult() == null || alert.getResult().equals(no)) {
            event.consume();
        }
    }
}