executor.submit(new Runnable() {
    public void run() {
        Log.v("PrintLN", "Executing Task");
        //your code here
        Log.v("PrintLN", "Done Task: " + resulting_time);
    }
});