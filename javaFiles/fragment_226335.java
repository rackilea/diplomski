public static class BackgroundTask extends Task<Object> {

    // .. variables used by the task here

    //constructor: initialize variables at every run of the Task
    public BackgroundTask() {

    }

    @Override
    protected Object call() throws Exception {
        if (!isCancelled()) {
            // ... Do all background work here

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    //  GUI progress can goes here                      
                }
            });

            //recursion here            
            if(something) {
                //...
            } else {
                call();
            }   

        } else {
            //user want to cancel task: clean GUI nodes
        }

    return null;
    }
}