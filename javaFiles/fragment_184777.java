InputMultiplexer inputMultiplexer = new InputMultiplexer();

    inputMultiplexer.addProcessor(stage);
    inputMultiplexer.addProcessor(cameraStage);

    Gdx.input.setInputProcessor(inputMultiplexer);