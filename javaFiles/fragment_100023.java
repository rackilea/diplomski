private final Executor aiExecutor = Executors.newSingleThreadExecutor();

// ...

currentBoardPane.addListener((e) -> {  
    if(gameManager.checkIfCurrentPlayerIsComputer()){

        Task<Void> makeMoveTask = new Task<Void>() {
            @Override
            protected Void call() {
                gameManager.playAutoMovesForCurrentPlayer();
                return null ;
            }
        };

        makeMoveTask.setOnSucceeded(e -> {

            //update board on scene
            gameManager.setNextPlayer(); // it does current player property = next player
            currentBoardPaneIndex = ((currentBoardPaneIndex + 1) % gameManager.getPlayers().size());
            currentBoardPane.setValue(boardPanes.get((currentBoardPaneIndex))); //this is a recursive call
        });

        aiExecutor.execute(makeMoveTask);
    }
});