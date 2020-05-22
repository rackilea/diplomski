/**
 * @param primaryStage stage used to run JavaFX program
 * @throws Exception thrown when the stage is not loaded correctly
 */
@Override
public void start(Stage primaryStage) throws Exception {

    game = primaryStage;

    MainMenu mainMenu = new MainMenu();
    ChooseSize chooseSize = new ChooseSize();

    theMainMenu = new Scene(mainMenu.getContent());
    chooseSizeMenu = new Scene(chooseSize.getContent());



    game.setTitle("Devon's Battleship");
    game.setScene(theMainMenu);
    game.show();
}

/**
 * main method that launches javaFX and loads the program
 * @param args
 */
public static void main(String[] args) throws IOException {

    launch(args);
}

/**
 * Sets the primaryStage scene to the scene provided by the parameter
 * @param sceneID, Scene to change to using its corresponding ID number
 */
public static void setScene(int sceneID)
{
    if (sceneID == 0)
    {
        game.setScene(theMainMenu);
    }
    if (sceneID == 1)
    {
        game.setScene(chooseSizeMenu);
    }

}