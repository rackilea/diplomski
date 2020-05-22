public class SecondController {
  private StringProperty text  = new SimpleStringProperty(this, "text", "");;
  @FXML
  private TextArea textArea2 ;
  public StringProperty textProperty() {
    return text ;
  }
  public final String getText() {
    return text.get();
  }
  public final void setText(String text) {
    this.text.set(text);
  }

  // ...

  @FXML 
  private void showTextAction(ActionEvent event) {
    text.set(textArea2.getText());
  }
}