stage = new Stage();
    viewport = new ExtendViewport(WIDTH, HEIGHT);
    viewport.setScreenPosition(500, 500); //I'm setting viewport's position

    ...

    @Override
    public void render(float delta) 
    {
        ...

        viewport.update(currentWindowWidth, currentWindowHeight, true); //here I'm updateing it with setting camera center

        ...
    }