InputMultiplexer inputMultiplexer = new InputMultiplexer();

    inputMultiplexer.addProcessor(stage1);
    inputMultiplexer.addProcessor(stage2);
    inputMultiplexer.addProcessor(stage3);
    ...

    Gdx.input.setInputProcessor(inputMultiplexer);