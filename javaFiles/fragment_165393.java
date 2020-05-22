package sexy.multithreaded.sprites;

public class GameDriver implements EventListener {
    final EventDispatcher dispatcher;
    final Framework framework;
    final List<Sprite> sprites;

    GameDriver(Framework framework) {
        framework.addEventListener(self);
        self.framework = framework;
        sprites = new ArrayList<>();
        dispatcher = new EventDispatcher(sprites);
    }

    public static void main(String[] args) {
        // register for events form your framework
        Framework f = new Framework(); // or window or whatever
        new GameDriver(f).startGame(Integer.parseInt(args[0]));
    }

    void startGame(int players) {
        // initialize game state
        for (int player = 0; player <= players; player++) {
            Sprite s = new Sprite(player);
            sprites.add(s);
            s.start();
        }
        // and your event processing thread
        dispatcher.start();

        // loop forever
        framework.processEvents();
    }

    @Override
    void onEvent(Event e) {
        if (e == Events.Quit) {
            dispatcher.interrupt();
        } eles {
            dispatcher.q.put(e);
        }
    }
}

class EventDispatcher extends Thread implements Runnable {
    // setup a queue for events
    final Queue<Event> q;
    final List<Sprite> sprites;

    EventDispatcher(List<Sprite> sprites) {
        super(this, "Event Dispatcher");
        this.sprites = sprites;
        q = new BlockingQueue<>();
    }

    @Override
    void run() {
        while (!interrupted()) {
            Event e = q.take();
            getSpriteForEvent(e).q.put(e);
        }
        for (Sprite s : sprites) {
            s.interrupt();
        }
    }
}

class Sprite extends Thread implements Runnable {
    final int num;
    final Queue<Event> q;

    Sprite(int num) {
        super(this, "Sprite " + num);
        self.num = num;
        q = new BlockingQueue<>();
    }

    @Override
    void run() {
        while (!interrupted()) {
            Event e = q.take();
            handle(e);
        }
    }

    void handle(Event e) {
        // remember we assumed this takes a really long time..
        // but how do I know how to calculate anything?
        switch (e) {
            case Events.UP:
                   // try to do something really long...
                   waitForUpvoteOn("a/35911559/1254812");
               break; // (;
            ...
        }
    }
}