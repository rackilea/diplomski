image.addListener(new ClickListener() 
    {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            Gdx.app.log("Image ClickListener", "clicked");
        }

        @Override
        public boolean keyDown(InputEvent event, int keycode) {
            Gdx.app.log("Image ClickListener", "keyDown. keycode=" + keycode);
            return true;
        }
    });

    stage.setKeyboardFocus(image);