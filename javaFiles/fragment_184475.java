public class Controller {
  @FXML
  private void testButton1() throws IOException {
    try {
      AnchorPane screen1 = FXMLLoader.load(getClass().getResource("screen1.fxml"));
      BorderPane border = Main.getRoot();
      border.setCenter(screen1);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
  @FXML
  private void testButton2() throws IOException {
    try {
      AnchorPane screen2 = FXMLLoader.load(getClass().getResource("screen2.fxml"));
      BorderPane border = Main.getRoot();
      border.setCenter(screen2);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}