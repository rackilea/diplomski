public class MessageViewController {
    private final Model model ;

    public MessageViewController(Model model) {
        this.model = model ;
    }

    @FXML
    public void addMessage() {
        model.getMessages().add(...);
    }
}