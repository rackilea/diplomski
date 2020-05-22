for(;;) {
    ball.move();
    window.setContentPane(ball);
    window.setContentPane(player);
    player.move();
}