class ParamTask implements Runnable (){
    String someArg;
    public ParamTask(String someArg){
        this.someArg = someArg;
    }    

    public run(){
        System.out.println("Runnable argument was: " + this.someArg);
    }
}

Thread argThread = new Thread(new ParamTask("this is a message"));

argThread.start();