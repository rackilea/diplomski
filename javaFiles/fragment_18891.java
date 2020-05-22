public class TopController {

    private Model model ;

    public void setModel(Model model) {
        this.model = model ;
    }

    @FXML
    private void someHandlerMethod(ActionEvent event) {
        model.doSomething();
    }
}