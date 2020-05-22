@Override
    public void setViewport(Viewport v)
    {
        super.setViewport(v);

        this.getViewport().update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false);

        Camera c = this.getViewport().getCamera();
        c.position.set(c.viewportWidth/2, c.viewportHeight/2, 0);

        init();
    }