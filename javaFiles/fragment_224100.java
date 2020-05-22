class LoginPane extends Pane    {
        public LoginPane()        {
            VBox root = new VBox();
            Button bt = new Button("OK");
            root.getChildren().add(bt);
            getChildren().add(root);
        }
    }