image.addAction(sequence(fadeOut(3), run(new Runnable() {
        @Override
        public void run() {
            game.setScreen(new MenuScreen(game));
        }
}));