import javafx.scene.input.Clipboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public void enablePaste() {
  super.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
    if(e.isShortcutDown() && e.getCode() == KeyCode.V) {
      Clipboard clipboard = Clipboard.getSystemClipboard();
      // your action here e.g.      
      // if (clipboard.hasUrl()) {
      //  
      //}
    }
  });
}