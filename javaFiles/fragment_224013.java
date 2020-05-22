@Override
public void start(Stage stage) throws Exception {
    final TextField tf = new TextField();
    final PasswordField pf = new PasswordField();
    Button b = new Button("post");
    b.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent t) {
            //Run a separate thread for posting and getting an answer.
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String login = tf.getText();
                    String pswd = pf.getText();

                    //Do post (read, from link below)

                    //Update of fragment from that article about POST in Java:
                    if (entity != null) {
                        InputStream instream = entity.getContent();
                        try {
                            //If you need to update of UI here, use Platform.runLater(Runnable);
                        } finally {
                            instream.close();
                        }
                    }
                }
            }).start();

            //Erase pswd, if needed
        }
    });
    stage.setScene(new Scene(new VBox(tf, pf, b), 300, 300));
    stage.show();
}