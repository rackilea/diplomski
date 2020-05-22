synchronized(lockObject) {
    while( ! condition ) {
        lockObject.wait();
    }
    //take the action here;
}