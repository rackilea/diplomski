public game(){
    setFocusable(true);

    initGame();
}

public void resetGame() {
    initGame();
}

private void initGame() {
    gamelooptimer = new Timer(10, this);
    gamelooptimer.start();

    p = new Player(MainClass.width / 2 - 60, 400);
    c = new ControllerEnemy();
    r = new ControllerRocket();
    e = new ControllerExplosion();
    menu = new Menu();
    gameover = new GameOver();

    addKeyListener(new KeyInput(p));
    addMouseListener(new MouseInput());
}