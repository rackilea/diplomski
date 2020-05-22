new Thread(new Runnable() {
    @override
    public void run() {
        game.loop();
    }
}).start();