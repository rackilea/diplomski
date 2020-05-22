public class PersonController {

    @FXML
    private Label nameLabel ;

    public void setName(String name) {
        nameLabel.setText(name);
    }
}