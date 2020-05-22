public static abstract class Repeat {
    public void loop(int c) {
        for (int i = 0; i < c; i++) {
            run();
        }
    }

    public void until() {
        while (isLooping()) {
            run();
        }
    }

    public abstract void run();
    public abstract boolean isLooping();
}