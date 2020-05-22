currentBoardPane.addListener((e) -> {  
    if(gameManager.checkIfCurrentPlayerIsComputer()){

        gameManager.playAutoMovesForCurrentPlayer();

        //update board on scene
        Platform.runLater(() -> {
            gameManager.setNextPlayer(); // it does current player property = next player
            currentBoardPaneIndex = ((currentBoardPaneIndex + 1) % gameManager.getPlayers().size());
            currentBoardPane.setValue(boardPanes.get((currentBoardPaneIndex))); //this is a recursive call
        });
    }
});