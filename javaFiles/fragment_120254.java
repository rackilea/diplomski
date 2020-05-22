public class Controller {

    @FXML
    private BorderPane mainBorderPane;
    @FXML
    public void initialize(){

    }

    @FXML
    public void newItemDialog(){
        Dialog <ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Insert Word");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("newDialog.fxml"));
        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch(IOException e) {
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();

        DialogController controller = fxmlLoader.getController();

        if(result.isPresent() && result.get() == ButtonType.OK){
            boolean results = controller.processResults();

        }else{
            System.out.println("Cancelled");
            return;
        }
    }

}