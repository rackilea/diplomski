final Processor processor = new Processor();

processor.process(new Process(...));

public void process( final Process process ) {
    new Thread(new Runnable() {
        //do somethig with process
        }).run();
}