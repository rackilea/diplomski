class GameDriver ... {
    static final DELTA = 10; // ms
    final Timer timer;
    ...
    GameDriver(...) {
        ...
        timer = new Timer(dispatcher, DELTA);
        dispatcher = new EventDispatcher(sprites, f.canvas(), map);
    }

    void startGame(...) {
        ...
        // and your event processing thread and timer
        dispatcher.start();
        timer.start();   
        ...
    }

    @Override
    void onEvent(Event e) {
        if (e == Events.Quit) {
            timer.stop();
            dispatcher.interrupt();
        } else {
            if (!dispatcher.q.offer(e)) {
                // Oh no! We're getting more events than we can handle.
                // To avoid getting into this situation you can try to:
                //   1. de-dupe/coalesce/buffer events
                //   2. increase your tick interval (decrease frame rate)
                //   3. drop events (I shot you I swear!)
            }
        }
    }
}

class EventDispatcher ... {
    // setup a queue for events
    final Queue<Event> q;
    final Canvas canvas;

    EventDispatcher(List<Sprite> sprites, Canvas c) {
        super(this, "Event Dispatcher");
        q = new BlockingQueue<>();
        canvas = c;
    }

    @Override
    void tick() {
        for (Sprite s : sprites) {
            canvas.push();
            s.draw(canvas);
            canvas.pop();
        }
    }
}

class Sprite ... implements Drawable ... {
    final Bitmap bitmap;
    final Matrix matrix;
    ...
    Sprite(int num) {
        ...
        URL url = Sprite.class.getResource("sprites/player-"+num+".bmp");
        bitmap = new Bitmap(url);
        matrix = new Matrix();
    }

    @Override
    void draw(Canvas c) {
        c.apply(matrix);
        c.paint(bitmap);
    }

    void handle(Event e) {
        switch (e) {
            case Events.Left:
               matrix.translate(GameDriver.DELTA, 0);
               break;
            case Events.Down:
               matrix.translate(0, GameDriver.DELTA);
            ...
        }
    }
}