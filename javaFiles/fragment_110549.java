restartButton.setOnAction( __ ->
{
  System.out.println( "Restarting app!" );
  primaryStage.close();
  Platform.runLater( () -> new ReloadApp().start( new Stage() ) );
} );