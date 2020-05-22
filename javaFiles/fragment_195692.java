class Engine {
    int boardSize;

    Engine () {
    Board board = new Board(this);
    }

    public void play() {
    }

    void doNothing() {
    // magic stuff in here
    }
}

class Board {
    Engine engine;

    Board (Engine gameEngine) {
    this.engine = gameEngine
    }

    void Test() {
        engine.doNothing(); // No error here :-) and this engine is your main one
    }
}