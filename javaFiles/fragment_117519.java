stage = new Stage(new ScreenViewport());

    Widget actor = new Widget();
    actor.setFillParent(true);
    actor.addListener(new InputListener() {

        @Override
        public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
            return true;
        }

        @Override
        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            Gdx.app.log("", "");
        }
    });
    stage.addActor(actor);


    Gdx.input.setInputProcessor(stage);