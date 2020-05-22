MyInputProcessor processor = new MyInputProcessor();
Gdx.input.setInputProcessor(processor);

...

if (processor.keyPressed) {
    // do some stuff
}