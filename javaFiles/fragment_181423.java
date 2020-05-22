/**
     * Sets up the main menu and loads the related fxml file
     * @throws IOException
     */
    public MainMenu() throws IOException {

        base = FXMLLoader.load(getClass().getResource("../res/MainMenuGUI.fxml"));

    }

    /**
     * Returns the main menu to load as the current scene
     * @return menu Main Menu of the game
     */
    public Parent getContent()
    {
        return base;
    }

    /**
     * Connected using Scene Builder to change the scene whenever the play game button is clicked
     * @param eventPlay
     */
    public void usePlayGame(ActionEvent eventPlay)
    {
        MainController.setScene(1);  //sceneID of chooseSizeMenu
    }