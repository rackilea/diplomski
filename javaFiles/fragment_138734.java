@Override
public void run() {
   Pane contents = new Pane();
   contents.setBackground(new Background(
              new BackgroundFill(jfxColour, new CornerRadii(0), new Insets(0))));

   Scene scene = new Scene(contents);

   jfxPanel.setScene(scene);
}