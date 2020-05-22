InputProcessor inputProcessorOne = new CustomInputProcessorOne();
InputProcessor inputProcessorTwo = new CustomInputProcessorTwo();
InputMultiplexer inputMultiplexer = new InputMultiplexer();
inputMultiplexer.addProcessor(inputProcessorOne);
inputMultiplexer.addProcessor(inputProcessorTwo);
Gdx.input.setInputProcessor(inputMultiplexer);