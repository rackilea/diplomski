public void run() {
    boolean success = performTask();

    if( success == false ){
        return; //ends the thread
    }   
    // further processing if success == true
}