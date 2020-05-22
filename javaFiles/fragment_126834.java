public static class FootballGame extends Game {

    private FootballGame(final Builder<?> builder) {
        super(builder);
    }

    public static class Builder<B extends HockeyGame.Builder<B>> extends Game.Builder<B> {

        float iceTemperature;

        @Override
        public FootballGame build() {
            return new FootballGame(this);
        }
    }
}