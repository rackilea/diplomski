ListView user_list = new ListView();

TextArea messages = new TextArea();
messages.setPrefRowCount(12);
messages.setPrefColumnCount(30);

TextField typebox = new TextField();
typebox.setPrefColumnCount(30);

Button send_text = new Button("Send");
send_text.disableProperty().bind(
    typebox.lengthProperty().lessThan(1));

SplitPane top = new SplitPane(user_list, messages);
top.setDividerPosition(0, 1/3.0);

BorderPane bottom = new BorderPane();
bottom.setCenter(typebox);
bottom.setRight(send_text);
BorderPane.setMargin(typebox, new Insets(0, 12, 0, 0));

BorderPane main = new BorderPane();
main.setCenter(top);
main.setBottom(bottom);
BorderPane.setMargin(bottom, new Insets(12));

Scene scene = new Scene(main);

primaryStage.setScene(scene); 
primaryStage.setTitle("Welcome");
scene.getStylesheets().add(LoginWindow.class.getResource("Login.css").toExternalForm());
primaryStage.show();