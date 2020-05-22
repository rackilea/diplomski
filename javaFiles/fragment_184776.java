//show method
    viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    // Creamos el stage, el cual albergara los botones entre otras cosas
    stage = new Stage(viewport);

    cameraStage = new Stage(viewport); //I'm not super-sure if you can user viewport second time - if not create new one

    ...

    //render method
    stage.act();
    stage.draw(); 

    cameraStage.act();
    cameraStage.draw(); //cameraStage is drawn after stage so it will be over it!

    ...