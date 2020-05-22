public class MainClass implements Initializable {
    @FXML
    private TextArea txtLoggingWindow;
    [...more code here...]
    public void appendText(String string, String string2) {
       txtLoggingWindow.appendText("[" + string + "] - " + string2 + "\n");
    }
}

public class SecondClass {
    private MainClass main;
    public SecondClass(MainClass mClass) {
        this.main = mClass;
    }
    public void callMainAndWriteToArea() {
        this.main.appendText(this.getClass().getCanonicalName(), "This Text Goes To TextArea");
    }
}