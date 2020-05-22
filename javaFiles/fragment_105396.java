// Stop the game
public void stop() {
    // Set the program's running state to false
    running = false;
    game.interrupt();//Cause blocking methods like Thread.sleep() to end with an Interrupted exception
    game.join();//Wait until the thread is completed
}