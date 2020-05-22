class Task implements Callable<String> {

    private final DataKey keys;

    public Task(DataKey keys) {
        this.keys = keys;   
    }

    public String call() throws Exception {

        // print whether it is USERFLOW or DEVICEFLOW? 
        System.out.println(keys.getFlow());

    }   
}