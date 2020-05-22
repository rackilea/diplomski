boolean running = true;
int delay = 15; // adjust the delay
while(running) {
    ball.move();
    player.move();
    window.setContentPane(ball);
    window.setContentPane(player);
    try {
        Thread.sleep(delay);
    } catch(InterruptedException e) {
        // We were interrupted while waiting
        // Something "woke us up". Stop the loop.
        e.printStackTrace();
        running = false;
    }
}