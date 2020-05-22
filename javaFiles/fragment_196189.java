interface GameFinishHandler {
    void doAfterGameFinished();
}

class MainMenu implements GameFinishHandler {
    ...

    private void createGame() {
        this.game = new Game();
        this.game.addHandler(this);
        // ...
    }

    @Override
    public void doAfterGameFinished() {
        game.setVisible(false);
        this.setVisible(true);
    }

class Game {
    private final List<GameFinishHandler> finishHandler = new ArrayList<>();

    public void addHandler(GameFinishHandler handler) {
        finishHandler.add(handler);
    }

    private void afterGameFinished() {
        finishHandler.forEach(GameFinishHandler::doAfterGameFinished);
    }