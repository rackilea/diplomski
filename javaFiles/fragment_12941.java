@Override
public void start(Stage primaryStage) throws Exception {
    YourAppMainWindow mainWindow = new YourAppMainWindow();
    // Load your main window Swing Stuff (remember to use 
    // SwingUtilities.invokeLater() to run inside the Event Dispatch Thread
    mainWindow.initSwingUI();

    // Now that the Swing stuff is loaded open a "hidden" primary stage
    // that will keep the FX Thread alive
    primaryStage.setWidth(0);
    primaryStage.setHeight(0);
    primaryStage.setX(Double.MAX_VALUE);
    primaryStage.setY(Double.MAX_VALUE);
    primaryStage.initStyle(StageStyle.UTILITY);
    primaryStage.show();
}