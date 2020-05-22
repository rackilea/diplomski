public class Navigator {

private final String P1;
private final String P2;
//then you can implement getters...
public String getP1() {
    return P1;
}

public String getP2() {
    return p2;
}

private static FxmlController Controller;

    public static void loadPane(String fxml) {
    try {
        FxmlController.setPane(
                (Node) FXMLLoader.load(Navigator.class.getResource(fxml)));
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public Navigator() throws IOException {
    this.P1 = "p1.fxml";
    this.P2 = "p2.fxml";}