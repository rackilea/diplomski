ExtendViewport viewport1, viewport2;
    Stage stage1 = new Stage(), stage2 = new Stage();

    @Override
    public void show() 
    {
        viewport1 = new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/3*2); 
        stage1.setViewport(viewport1);  

        viewport2 = new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/3);        
        stage2.setViewport(viewport2); 

        //... adding actors etc     
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //here you are centering camera
        viewport2.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/3, true); 
        stage2.act(delta); 
        stage2.draw(); 

        //here you are centering camera
        viewport1.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/3*2, true);

        //here you are positioning the viewport on the screen
        viewport1.setScreenY(Gdx.graphics.getHeight()/3);
        viewport1.apply(true);

        stage1.act(delta); 
        stage1.draw();         
    }