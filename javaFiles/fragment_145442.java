PrintStream error=System.err;
    System.setErr(new PrintStream(new OutputStream(){
        public void write(int a){}
    }));
    controllers=ControllerEnvironment.getDefaultEnvironment().getControllers();
    System.setErr(error);