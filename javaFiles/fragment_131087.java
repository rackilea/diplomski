final Button imageJumpButton = new Button(new TextureRegionDrawable(new TextureRegion(new Texture("jbjump.png"))));
//use ChangeListener instead of InputListener
imageJumpButton.addListener(new ChangeListener() {
        @Override
        public void changed(ChangeEvent event, Actor actor) {
            Gdx.app.log("", "Button is pressed");
        }
    });