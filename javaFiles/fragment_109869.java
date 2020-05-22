public void run() {
    if(!my_runnables.isEmpty()) {

        int progress = 0;

        while(true) {
            for(Runnable r : my_runnables) {
                if(r instanceof Verify_TestRun) {
                    Verify_TestRun run = (Verify_TestRun)r;
                    //change #1 - sum up the progress value of each test
                    progress += run.get_progress();
                    all_runnable_progress.put(run.get_category(), progress);
                }
            }

            //change #2 - break when all done
            if(progress < (100 * my_runnables.size()) ) { 
                //check if tests are still running i.e. there are test runs with progress < 100
                print_progress();
            } else {
                //otherwise print one last status (to update all status' to 100%) before stopping the loop
                print_progress();
                break;
            }

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}