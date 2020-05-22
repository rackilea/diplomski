public void openFile() throws IOException {
  FileChooser chooser = new FileChooser()
  chooser.title = "Select FXML"
  chooser.setInitialDirectory( new File( "." ) );
  chooser.extensionFilters.add( new FileChooser.ExtensionFilter( 
    "FXML or SVG Files",
    ["*.fxml", "*.svg"] 
  ))

  Window window = sceneProperty.get().window
  File selected = chooser.showOpenDialog( window )
}