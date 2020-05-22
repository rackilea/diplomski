public class Controller {

    private ContentB contentB  ;


    public enum Content {
        A(() -> new ContentA()),
        B(() -> contentB) ;


        private final Supplier<Node> nodeLoader ;

        Content(Supplier<Node> nodeLoader) {
            this.nodeLoader = nodeLoader ;
        }

        public Node getContent() {
            return nodeLoader.get();
        }
    }

    private Content currentContent ; 


    @FXML
    public void initialize() {

        contentB = new ContentB();

        contentIndex = splitPane.getItems().size() ;
        changeContent(Content.A);
    }



    @FXML
    public void onMenuClickA(ActionEvent event) {
        changeContent(Content.A);
    }
    @FXML
    public void onMenuClickB(ActionEvent event) {
        changeContent(Content.B);
    }

    private void changeContent(Content content) {
        this.currentContent = content ;
        splitpaneItems.set(contentIndex, content.getContent());
    }

}