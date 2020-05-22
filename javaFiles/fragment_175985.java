Timer timer = new Timer(10,(e)->{
    if (game.upPressed)
    {
        game.moveBallUP();
        game.repaint();
    }

    if (game.downPressed)
    {
        game.moveBallDOWN();
        game.repaint();
    }

    if (game.leftPressed)
    {
        game.moveBallLEFT();
        game.repaint();
    }

    if (game.rightPressed)
    {
        game.moveBallRIGHT();
        game.repaint();
    }
});
timer.start();