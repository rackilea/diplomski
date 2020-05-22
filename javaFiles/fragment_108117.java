class DisplayDataTask extends Task<Integer> {

    @Override
    protected Integer call() throws Exception {

        int randomNum = 71890;

        Thread.sleep(5000); // Sleep for 5 seconds to simulate a task 

        Integer size = randomNum ;
        return size;
    }

    @Override
    protected void cancelled() {
        super.cancelled();

        updateMessage("Operation Cancelled");
        System.out.println("The " + this.getClass().getSimpleName() + " has been canceled.");
    }   
}