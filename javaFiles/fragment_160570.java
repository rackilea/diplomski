public void callAsyncTask() {
    try {
        Future<String> future =  asyncTask.run();
        // Do some other things while the async task is running.
        // future.get() will block the function and wait for the result.
        String asyncResult = future.get();
    } catch(InterruptedException e) {
        e.printStackTrace();
        // Do something else.
    }
}