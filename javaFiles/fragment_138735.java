@Override
public void run() {
   Pane contents = new Pane();
   contents.setBackground(new Background(
              new BackgroundFill(jfxColour, new CornerRadii(0), new Insets(0))));

   // Scene scene = new Scene(contents);
   Scene scene = new Scene(contents, javafx.scene.paint.Color.BLACK);
                                                         // !!!!!!!!
   jfxPanel.setScene(scene);
}