public enum States {
    MAIN_MENU("../gui/MainWindow.fxml"), NEW_GAME("../gui/NewGameWindow.fxml");
    private final url;

    States(String url) {
        this.url = url;
    }
}