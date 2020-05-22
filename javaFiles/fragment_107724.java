public class Controller {

    // If you still need access to the URL or ResourceBundle
    @FXML private URL location;
    @FXML private ResourceBundle resources;

    @FXML
    private void initialize() throws Exception { // can now add throws clause
        File file = new File("C:\\Users\\konta\\IdeaProjects\\project\\files\\rememberme.xml");
        boolean exists = file.exists();
        if (exists) {
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse(file);
                document.getDocumentElement().normalize();
                savedUsername = document.getElementsByTagName("Username").item(0).getTextContent();
                savedPassword = document.getElementsByTagName("Password").item(0).getTextContent();

            if (savedUsername.length() >= 1 && savedPassword.length() == 44) {
                usernameInput.setText(username);
                passwordInput.setText(password);
            }
        }
    }

}