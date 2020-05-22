import java.util.concurrent.atomic.AtomicBoolean;

class B {
    private AtomicBoolean game_over;

    public B(AtomicBoolean game_over) {
        this.game_over = game_over;
    }

    public void run() {
        // do stuff
        game_over.set(true);
    }
}