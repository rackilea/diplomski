class GameDriver ... {
    void startGame(...) {
        // don't need to start() the sprites anymore..
        ...
            // give sprites a starting position
            sprite.matrix.translate(0, player);
    }
}

class EventDispatcher extends Thread implements Runnable {

    final Map<Matrix, Sprite> map;
    ...
    EventDispatcher(...) {
        ...
        map = new HashMap<>();
    }

    ...
    @Override
    void tick() {
        for (Sprite s : sprites) {
            // assuming we gave matrix a map-unique hash function
            checkBounds(s);
            map.put(s.matrix, s);
        }
        // process collisions or otherwise apply game logic
        applyLogic(map);
        map.clear();

        // draw the sprites (or use yet another thread)
        for (Sprite s : sprites) {
            canvas.push();
            s.draw(canvas);
            canvas.pop();
        }
    }

    @Override
    void run() {
        try {
            while (!interrupted()) {
                Event e = q.take();
                getSpriteForEvent(e).handle(e)
            }
        } catch (InterruptedException e) {
        } finally {
            for (Sprite s : sprites) {
                s.interrupt();
            }
        }
    }
    ...
}

class Sprite implements Drawable {
    ...
    // scratch the run method and thread constructor
    ...
}