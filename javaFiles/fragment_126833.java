public class Game {

    private final int score;
    private final int timeLimit;

    private Game(final Builder<?> builder) {
        this.score = builder.score;
        this.timeLimit = builder.timeLimit;
    }

    public static class Builder<B extends Builder<B>> {

        private int score;
        private int timeLimit;

        public B setScore(int score) {
            this.score = score;
            return getThis();
        }

        public B setTimeLimit(int timeLimit) {
            this.timeLimit = timeLimit;
            return getThis();
        }

        protected B getThis() {
            return (B) this;
        }

        public Game build() {
            return new Game(this);
        }
    }
}

public class HockeyGame extends Game {

    private final float iceTemperature;

    private HockeyGame(final Builder<?> builder) {
        super(builder);
        this.iceTemperature = builder.iceTemperature;
    }

    public static class Builder<B extends Builder<B>> extends Game.Builder<B> {

        private float iceTemperature;

        public B setIceTemperature(float iceTemperature) {
            this.iceTemperature = iceTemperature;
            return getThis();
        }

        @Override
        public HockeyGame build() {
            return new HockeyGame(this);
        }
    }
}