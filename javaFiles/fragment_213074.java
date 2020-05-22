public class BackButtonController {
@FXML
private Button btnBack;

private final Runnable runnable;

public BackButtonController(Runnable r) {
    this.runnable= r;
}

@FXML
protected void initialize() {
    this.btnBack.setOnMouseClick(() -> buttonClick());
}

public void btnClick() {
    runnable.run();
//Alternatively, if you want to run it in a separate Thread, use 
    new Thread(runnable).start();
}