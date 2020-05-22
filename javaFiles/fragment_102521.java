InputMultiplexer multiplexer = new InputMultiplexer();
    Array<InputProcessor> processors = new Array<InputProcessor>();
    MyInputProcessor myInputProcessor = new MyInputProcessor(); 
    processors.add(myInputProcessor);
    processors.add(stage);
    this.multiplex.setProcessors(processors);

    //...
    //and in your show method in your Screen class
    Gdx.input.setInputProcessor(this.multiplex);