public void myMethod(...) {
    . . .
}

// later:

long timeInNanoSeconds = timeMethod(new Runnable() {
    public void run() {
        myMethod(...);
    }
});