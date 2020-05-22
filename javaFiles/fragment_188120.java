// Task for your simulation
Task<Integer> task = new Task<Integer>(){

    @Override
    protected Integer call() throws Exception {
        MonteCarlo montecarlo = new MonteCarlo(gameBoard);
        return montecarlo.nextMove();
    }

};

// If you want to disable the GUI while your simulation runs (root is the root Node of your Scene graph)
// root.setDisable(true); 

// When the task finished, update the GUI with the step
task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {

    @Override
    public void handle(WorkerStateEvent event) {
        int field = task.getValue();
        int x = field % 5;
        int y = field / 5;
        arrayToMouseXY(x, y);
        arrayX = x;
        arrayY = y;
        System.out.println("Black rock on " + field + ": " + arrayX + ", " + arrayY);
        putRock(arrayX, arrayY, GameBoard.stoneColor.BLACK);
        gameBoard.setField(arrayX, arrayY, GameBoard.stoneColor.BLACK);
        player1 = true;

        gameBoard.printFields();
        // "release" the GUI
        // root.setDisable(false); 
    }
});

// Start the thread
Thread thread = new Thread(task);
thread.setDaemon(true);
thread.start();