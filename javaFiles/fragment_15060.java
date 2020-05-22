timeTakenFunc(new Runnable() {
    @Override public void run() {
        foo(arr);
    }
});
timeTakenFunc(new Runnable() {
    @Override public void run() {
        bar(arr);
    }
});