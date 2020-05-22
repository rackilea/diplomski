String command = input.getInput();
CommandManager commandManager = CommandManager.fromCommand(command);
if (commandManager != null)  {
    switch (commandManager) {
        case MAINMENU: 
            goToMainMenu();
            break;
        case NEWGAME: 
            startNewGame();
            break;
        case LISTGAMES: 
            listSavedGames();
            break;
        case EXITGAME: 
            exitGame();
            break;
        case HELPMENU: 
            listAllCommands();
            break;
        default:
            throw new IllegalArgumentException("Unknown command: " + commandManager);
    }
}