play.addListener(new InputListener(){

        boolean playing = false;

        @Override
        public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
            super.enter(event, x, y, pointer, fromActor);
            if (!playing) {
                Sound sound = Gdx.audio.newSound(Gdx.files.internal("data/mysound.mp3"));
                sound.play(1F);
                playing = true;
            }
        }

        @Override
        public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
            super.exit(event, x, y, pointer, toActor);
            playing = false;
        }
    });