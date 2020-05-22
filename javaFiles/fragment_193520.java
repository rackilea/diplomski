public class LoginView {

    private final Stage displayStage ;

    private final Scene scene ;

    public LoginView(Stage displayStage) throws IOException {
        this.displayStage = displayStage ;
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("/design/Login.fxml"));
        Parent root = loader.load();        
        scene = new Scene(root);
        displayStage.setScene(scene);
        displayStage.setTitle("Benutzerverwaltung");
    }

    public LoginView() throws IOException {
        this(new Stage());
    }

    public void show() {
        displayStage.show();
    }

    public void hide() {
        displayStage.hide();
    }

    // ...
}