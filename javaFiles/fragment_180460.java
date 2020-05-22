stage.addListener(new InputListener() 
    {
        @Override
        public boolean keyDown(InputEvent event, int keycode) 
        {
            Gdx.app.log("Image ClickListener", "keyDown. keycode=" + keycode);
            return true;
        }
    });