import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.image.BufferedImage;
import java.util.function.Predicate;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public class Main extends Application {

  private Stage primaryStage;
  private boolean iconAdded;

  @Override
  public void start(Stage primaryStage) throws AWTException {
    if (SystemTray.isSupported()) {
      installSystemTray();
      Platform.setImplicitExit(false);

      StackPane root = new StackPane(new Label("Hello, World!"));
      primaryStage.setScene(new Scene(root, 500, 300));
      primaryStage.setTitle("JavaFX Application");
      primaryStage.setOnCloseRequest(this::promptUserForDesiredAction);

      this.primaryStage = primaryStage;
    } else {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setHeaderText(null);
      alert.setContentText("SystemTray is not supported. Will exit application.");
      alert.showAndWait();
      Platform.exit();
    }
  }

  @Override
  public void stop() {
    if (iconAdded) {
      SystemTray tray = SystemTray.getSystemTray();
      for (TrayIcon icon : tray.getTrayIcons()) {
        tray.remove(icon);
      }
    }
  }

  private void promptUserForDesiredAction(WindowEvent event) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.initOwner((Window) event.getSource());
    alert.setTitle("Choose Action");
    alert.setHeaderText(null);
    alert.setContentText("Would you like to exit or hide the application?");

    // Use custom ButtonTypes to give more meaningful options
    // than, for instance, OK and CANCEL
    ButtonType exit = new ButtonType("Exit");
    ButtonType hide = new ButtonType("Hide");
    alert.getDialogPane().getButtonTypes().setAll(exit, hide);

    alert.showAndWait().filter(Predicate.isEqual(exit)).ifPresent(unused -> Platform.exit());
  }

  private void installSystemTray() throws AWTException {
    TrayIcon icon = new TrayIcon(createSystemTrayIconImage(), "Show JavaFX Application");
    // On Windows 10, this listener is invoked on a double-click
    icon.addActionListener(e -> Platform.runLater(() -> {
      if (primaryStage.isShowing()) {
        primaryStage.requestFocus();
      } else {
        primaryStage.show();
      }
    }));
    SystemTray.getSystemTray().add(icon);
    iconAdded = true;
  }

  // Creates a simple red circle as the TrayIcon image. This is here
  // to avoid needing an image resource for the example.
  private BufferedImage createSystemTrayIconImage() {
    Circle circle = new Circle(6.0, Color.FIREBRICK);
    Scene scene = new Scene(new Group(circle), Color.TRANSPARENT);
    return SwingFXUtils.fromFXImage(circle.snapshot(null, null), null);
  }

}