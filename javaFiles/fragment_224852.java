private void start(String[] args) {

    // Get list of ids create a new consumer for each id

    for (int index = 0; index < everyID.length; index++) {
        consExec.execute(new Consumer(everyID[i]));
    }

}