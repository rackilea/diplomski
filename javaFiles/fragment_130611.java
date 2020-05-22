package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class Main extends Application
{
  @Override
  public void start(Stage primaryStage)
  {
    try
    {
      final HTMLEditor editor = new HTMLEditor();
      Scene scene = new Scene(editor);
      primaryStage.setScene(scene);

      editor.setOnKeyReleased(new EventHandler<KeyEvent>()
      {
        @Override
        public void handle(KeyEvent event)
        {
          if (isValidEvent(event))
          {
            System.out.println(editor.getHtmlText());
          }
        }

        private boolean isValidEvent(KeyEvent event)
        {
          return !isSelectAllEvent(event)
              && ((isPasteEvent(event)) || isCharacterKeyReleased(event));
        }

        private boolean isSelectAllEvent(KeyEvent event)
        {
          return event.isShortcutDown() && event.getCode() == KeyCode.A;
        }

        private boolean isPasteEvent(KeyEvent event)
        {
          return event.isShortcutDown() && event.getCode() == KeyCode.V;
        }

        private boolean isCharacterKeyReleased(KeyEvent event)
        {
          // Make custom changes here..
          switch (event.getCode())
          {
            case ALT:
            case COMMAND:
            case CONTROL:
            case SHIFT:
              return false;
            default:
              return true;
          }
        }
      });

      primaryStage.show();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public static void main(String[] args)
  {
    launch(args);
  }
}