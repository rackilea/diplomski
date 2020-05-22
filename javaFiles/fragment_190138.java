class Server {
    Map<Game, BlockingQueue> games = ....;

    void createGame() {
        BlockingQueue queue = ....;
        Game game = new Game(queue);
        games.put(game, queue);
    }

    void foo() {
       Game game = ....; 
       Action action = ....; // identify the Game
       map.get(g).add(action);
    }
}

class Game {
    BlockingQueue _queue;

    Game(BlockingQueue queue) { 
         _queue = queue; 
    }

    void run() {
        while (true) {
            Action nextAction = _queue.take();
            // perform the action
        }
    }
}